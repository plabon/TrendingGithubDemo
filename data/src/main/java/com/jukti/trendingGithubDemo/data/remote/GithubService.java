package com.jukti.trendingGithubDemo.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class GithubService {

    private static GithubService instance;
    public static GithubService getInstance(){
        if(instance==null){
            instance=new GithubService();
        }
        return instance;
    }

    public GithubApi getGithubApiService() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(GithubApi.class);
    }
}
