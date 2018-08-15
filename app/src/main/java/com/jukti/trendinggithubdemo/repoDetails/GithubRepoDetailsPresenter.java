package com.jukti.trendinggithubdemo.repoDetails;

import com.jukti.trendinggithubdemo.UseCaseHandler;
import com.jukti.trendinggithubdemo.mapper.DomainToViewModelMapperImp;
import com.jukti.trendinggithubdemo.models.GithubRepoModel;

import java.jukti.trendingGithubDemo.domain.interactors.repos.GetRepoListUseCase;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class GithubRepoDetailsPresenter implements RepoDetailsContract.Presenter {

    private RepoDetailsContract.View view;
    private UseCaseHandler mUseCaseHandler;
    private GithubRepoModel githubRepoModel;

    public GithubRepoDetailsPresenter(UseCaseHandler useCaseHandler,
                                      RepoDetailsContract.View repoListView) {
        mUseCaseHandler = useCaseHandler;
        view = repoListView;
    }





    @Override
    public void start() {
        view.showDescription(githubRepoModel);
    }

    @Override
    public void setModel(GithubRepoModel model) {
        this.githubRepoModel = model;
    }

    @Override
    public void onBackpressed() {
        view.close();

    }
}
