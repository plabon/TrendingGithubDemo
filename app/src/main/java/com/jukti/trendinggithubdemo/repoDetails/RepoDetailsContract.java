package com.jukti.trendinggithubdemo.repoDetails;

import com.jukti.trendinggithubdemo.base.BasePresenter;
import com.jukti.trendinggithubdemo.base.BaseView;
import com.jukti.trendinggithubdemo.models.GithubRepoModel;

import java.util.List;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public interface RepoDetailsContract {

    public interface View extends BaseView<Presenter> {
        void showDescription(GithubRepoModel model);
        void showLoadingProgress(boolean isShow);
        void showErrorMsg();
        void close();
    }
    public interface Presenter extends BasePresenter {
        void setModel(GithubRepoModel model);
        void onBackpressed();
    }

}
