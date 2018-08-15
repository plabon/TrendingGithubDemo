package com.jukti.trendinggithubdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.RemoteViewsService;

import com.jukti.trendingGithubDemo.data.AppExecutors;
import com.jukti.trendingGithubDemo.data.GithubTrendingRepositoryImp;
import com.jukti.trendingGithubDemo.data.remote.GithubRemoteDataSource;
import com.jukti.trendingGithubDemo.data.remote.GithubService;

import java.jukti.trendingGithubDemo.domain.interactors.repos.GetRepoListUseCase;
import java.jukti.trendingGithubDemo.domain.repository.GithubRepoRepository;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class Injection {

    @NonNull
    public static GetRepoListUseCase provideGetRepos(@NonNull Context context) {
        return new GetRepoListUseCase(provideRepoRepository(context));
    }
    public static UseCaseHandler provideUseCaseHandler() {
        return UseCaseHandler.getInstance();
    }

    public static GithubRepoRepository provideRepoRepository(Context context) {
        GithubService service = GithubService.getInstance();
        return GithubTrendingRepositoryImp.getInstance(GithubRemoteDataSource.getInstance(new AppExecutors(), service.getGithubApiService()));
    }
}
