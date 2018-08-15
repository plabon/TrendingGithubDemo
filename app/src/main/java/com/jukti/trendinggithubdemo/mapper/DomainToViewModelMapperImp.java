package com.jukti.trendinggithubdemo.mapper;

import com.jukti.trendinggithubdemo.models.GithubRepoModel;

import java.jukti.trendingGithubDemo.domain.models.GithubRepoDomainModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class DomainToViewModelMapperImp implements DomainToViewModelMapper {

    @Override
    public GithubRepoModel mapGithubRepoDomainToGithubViewModel(GithubRepoDomainModel githubRepoDomainModel) {
        return new GithubRepoModel(githubRepoDomainModel.getId(),githubRepoDomainModel.getHtmlUrl(),githubRepoDomainModel.getUrl(),
                githubRepoDomainModel.getName(),githubRepoDomainModel.getLanguage(),githubRepoDomainModel.getDescription(),
                githubRepoDomainModel.getWatchsCount(),githubRepoDomainModel.getNodeId(),githubRepoDomainModel.getStargazersCount(),
                githubRepoDomainModel.getWatchers());
    }

    @Override
    public List<GithubRepoModel> mapGithubRepoDomainListToGithubRepoViewModelList(List<GithubRepoDomainModel> githubRepoDomainList) {
        List<GithubRepoModel> repoList=new ArrayList<>();
        for(GithubRepoDomainModel domainModel:githubRepoDomainList)
            repoList.add(mapGithubRepoDomainToGithubViewModel(domainModel));
        return repoList;
    }
}
