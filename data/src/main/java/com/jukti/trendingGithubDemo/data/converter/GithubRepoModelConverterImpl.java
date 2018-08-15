package com.jukti.trendingGithubDemo.data.converter;

import com.jukti.trendingGithubDemo.data.entity.GithubRepoEntity;

import java.jukti.trendingGithubDemo.domain.models.GithubRepoDomainModel;
import java.util.ArrayList;
import java.util.List;

public class GithubRepoModelConverterImpl implements RepoModelConverter {


    @Override
    public GithubRepoDomainModel modelToDomain(GithubRepoEntity entity) {
        return new GithubRepoDomainModel(entity.getId(),entity.getHtmlUrl(),entity.getUrl(),
                entity.getName(),entity.getLanguage(),entity.getDescription(),entity.getWatchsCount(),
                entity.getNodeId(),entity.getStargazersCount(),entity.getWatchers());
    }

    @Override
    public List<GithubRepoDomainModel> modelListToDomainList(List<GithubRepoEntity> entityList) {
        List<GithubRepoDomainModel> repoList=new ArrayList<>();
        for(GithubRepoEntity entity:entityList){
            repoList.add(modelToDomain(entity));
        }
        return repoList;
    }


}
