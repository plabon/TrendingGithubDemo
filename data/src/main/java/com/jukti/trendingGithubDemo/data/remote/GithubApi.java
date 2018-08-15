package com.jukti.trendingGithubDemo.data.remote;

import com.jukti.trendingGithubDemo.data.entity.GithubRepoEntity;
import com.jukti.trendingGithubDemo.data.entity.ListWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubApi {

    String BASE_URL = "https://api.github.com";

    @GET("/search/repositories?q=created:>2018-01-01+language:java&sort=stars&order=desc&per_page=30")
    Call<ListWrapper<GithubRepoEntity>> getTrendingRepos(@Query("page") int pageNumber);

}
