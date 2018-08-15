package com.jukti.trendinggithubdemo.repoList;

import com.jukti.trendinggithubdemo.base.BasePresenter;
import com.jukti.trendinggithubdemo.base.BaseView;
import com.jukti.trendinggithubdemo.models.GithubRepoModel;

import java.util.List;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public interface RepoListContract {

    public interface View extends BaseView<Presenter> {
        void showRepos(List<GithubRepoModel> repos);
        void showLoadingProgress(boolean isShow);
        void showErrorMsg();
        void startDetailActivity(GithubRepoModel model);
    }
    public interface Presenter extends BasePresenter {
        void doSearch(String searchKey);
        void getAllRepos();
        void onClickRepoItem(GithubRepoModel model);
    }

}
