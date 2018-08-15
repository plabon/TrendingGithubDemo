package com.jukti.trendinggithubdemo.repoList;

import com.jukti.trendinggithubdemo.UseCaseHandler;
import com.jukti.trendinggithubdemo.mapper.DomainToViewModelMapperImp;
import com.jukti.trendinggithubdemo.models.GithubRepoModel;

import java.jukti.trendingGithubDemo.domain.interactors.repos.GetRepoListUseCase;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class GithubRepoListPresenter implements RepoListContract.Presenter {

    private RepoListContract.View view;
    private UseCaseHandler mUseCaseHandler;
    private GetRepoListUseCase mGetWordListUseCase;

    public GithubRepoListPresenter(UseCaseHandler useCaseHandler,
                                   GetRepoListUseCase getRepoListUseCase,
                                   RepoListContract.View repoListView) {
        mUseCaseHandler = useCaseHandler;
        mGetWordListUseCase = getRepoListUseCase;
        view = repoListView;
    }


    @Override
    public void doSearch(String searchKey) {

    }

    @Override
    public void getAllRepos() {
        view.showLoadingProgress(true);
        /**
         here if pagination is implemented in recyclerview we need to send dynamic pageNumber while
         creating {@link GetRepoListUseCase.GetRepoListRequest} object
         */
        GetRepoListUseCase.GetRepoListRequest requestValues = new GetRepoListUseCase.GetRepoListRequest("", 1);
        mUseCaseHandler.execute(mGetWordListUseCase, requestValues, new GetRepoListUseCase.Callback<GetRepoListUseCase.GetRepoListResponse>() {
            @Override
            public void onSuccess(GetRepoListUseCase.GetRepoListResponse response) {
                view.showRepos(new DomainToViewModelMapperImp().mapGithubRepoDomainListToGithubRepoViewModelList(response.getRepos()));
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void onClickRepoItem(GithubRepoModel model) {
        view.startDetailActivity(model);
    }


    @Override
    public void start() {

    }
}
