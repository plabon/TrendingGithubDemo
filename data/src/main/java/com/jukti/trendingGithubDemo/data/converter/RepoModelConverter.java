package com.jukti.trendingGithubDemo.data.converter;

import com.jukti.trendingGithubDemo.data.entity.GithubRepoEntity;

import java.jukti.trendingGithubDemo.domain.models.GithubRepoDomainModel;
import java.util.List;

public interface RepoModelConverter {

    GithubRepoDomainModel modelToDomain(GithubRepoEntity entity);
    List<GithubRepoDomainModel> modelListToDomainList(List<GithubRepoEntity> entityList);

}
