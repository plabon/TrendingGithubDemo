package java.jukti.trendingGithubDemo.domain.repository;

import java.jukti.trendingGithubDemo.domain.interactors.repos.GetRepoListUseCase;
import java.jukti.trendingGithubDemo.domain.models.GithubRepoDomainModel;
import java.util.List;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public interface GithubRepoRepository {

        interface GetTrendingRepoCallback {

            void onFetchReposComplete(List<GithubRepoDomainModel> repos);

            void onDataNotAvailable();

            void onError();
        }



        void getAllTrendingRepos(GetRepoListUseCase.GetRepoListRequest requestValues, GetTrendingRepoCallback callback);



}
