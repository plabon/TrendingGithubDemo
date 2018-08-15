package com.jukti.trendingGithubDemo.data;

import android.support.annotation.NonNull;

import com.jukti.trendingGithubDemo.data.remote.GithubRemoteDataSource;

import java.jukti.trendingGithubDemo.domain.interactors.repos.GetRepoListUseCase;
import java.jukti.trendingGithubDemo.domain.repository.GithubRepoRepository;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class GithubTrendingRepositoryImp implements GithubRepoRepository {
    private final GithubRemoteDataSource githubRemoteDataSource;
    private static GithubTrendingRepositoryImp instance;

    public GithubTrendingRepositoryImp(@NonNull GithubRemoteDataSource remoteDataSource) {
        this.githubRemoteDataSource = remoteDataSource;
    }

    public static GithubTrendingRepositoryImp getInstance(GithubRemoteDataSource remoteDataSource) {
        if (instance == null) {
            instance = new GithubTrendingRepositoryImp(remoteDataSource);
        }
        return instance;
    }

    @Override
    public void getAllTrendingRepos(GetRepoListUseCase.GetRepoListRequest requestValues, GetTrendingRepoCallback callback) {
        githubRemoteDataSource.getTrendingGithubRepos(requestValues,callback);
    }


}
