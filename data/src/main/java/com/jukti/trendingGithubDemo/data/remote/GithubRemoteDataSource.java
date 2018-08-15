package com.jukti.trendingGithubDemo.data.remote;

import android.support.annotation.NonNull;

import com.jukti.trendingGithubDemo.data.AppExecutors;
import com.jukti.trendingGithubDemo.data.converter.GithubRepoModelConverterImpl;
import com.jukti.trendingGithubDemo.data.entity.GithubRepoEntity;
import com.jukti.trendingGithubDemo.data.entity.ListWrapper;

import java.jukti.trendingGithubDemo.domain.interactors.repos.GetRepoListUseCase;
import java.jukti.trendingGithubDemo.domain.repository.GithubRepoRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class GithubRemoteDataSource {
    private static volatile GithubRemoteDataSource INSTANCE;
    private AppExecutors mAppExecutors;
    private GithubApi githubApi;

    // Prevent direct instantiation.
    private GithubRemoteDataSource(@NonNull AppExecutors appExecutors,
                                @NonNull GithubApi api) {
        mAppExecutors = appExecutors;
        githubApi = api;
    }

    public static GithubRemoteDataSource getInstance(@NonNull AppExecutors appExecutors,
                                                  @NonNull GithubApi api) {
        if (INSTANCE == null) {
            synchronized (GithubRemoteDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GithubRemoteDataSource(appExecutors, api);
                }
            }
        }
        return INSTANCE;
    }
    public void getTrendingGithubRepos(GetRepoListUseCase.GetRepoListRequest requestValues, final GithubRepoRepository.GetTrendingRepoCallback callback){
        githubApi.getTrendingRepos(requestValues.getPageNumber()).enqueue( new Callback<ListWrapper<GithubRepoEntity>>() {
            @Override
            public void onResponse(Call<ListWrapper<GithubRepoEntity>> call, Response<ListWrapper<GithubRepoEntity>> response) {
                if (response.isSuccessful()) {
                   callback.onFetchReposComplete(new GithubRepoModelConverterImpl().modelListToDomainList(response.body().items));
                } else {
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<ListWrapper<GithubRepoEntity>> call, Throwable t) {
                callback.onError();
            }
        });
    }


}
