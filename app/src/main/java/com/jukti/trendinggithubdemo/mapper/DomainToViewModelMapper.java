package com.jukti.trendinggithubdemo.mapper;
import com.jukti.trendinggithubdemo.models.GithubRepoModel;

import java.jukti.trendingGithubDemo.domain.models.GithubRepoDomainModel;
import java.util.List;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public interface DomainToViewModelMapper {
    GithubRepoModel mapGithubRepoDomainToGithubViewModel(GithubRepoDomainModel githubRepoDomainModel);
    List<GithubRepoModel> mapGithubRepoDomainListToGithubRepoViewModelList(List<GithubRepoDomainModel> githubRepoDomainList);
}
