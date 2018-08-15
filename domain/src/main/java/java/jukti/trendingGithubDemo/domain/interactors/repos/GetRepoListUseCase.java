package java.jukti.trendingGithubDemo.domain.interactors.repos;

import java.jukti.trendingGithubDemo.domain.interactors.UseCase;
import java.jukti.trendingGithubDemo.domain.models.GithubRepoDomainModel;
import java.jukti.trendingGithubDemo.domain.repository.GithubRepoRepository;
import java.util.List;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class GetRepoListUseCase extends UseCase<GetRepoListUseCase.GetRepoListRequest, GetRepoListUseCase.GetRepoListResponse> {


    private GithubRepoRepository githubRepository;

    public GetRepoListUseCase(GithubRepoRepository gRepository) {
        this.githubRepository = gRepository;
    }

    @Override
    public void execute(final GetRepoListRequest requestValues) {
        githubRepository.getAllTrendingRepos(requestValues, new GithubRepoRepository.GetTrendingRepoCallback() {

            @Override
            public void onFetchReposComplete(List<GithubRepoDomainModel> repos) {
                GetRepoListResponse response = new GetRepoListResponse(repos);
                getmCallback().onSuccess(response);
            }

            @Override
            public void onDataNotAvailable() {
                getmCallback().onError();
            }

            @Override
            public void onError() {
                getmCallback().onError();
            }
        });
    }

    public static final class GetRepoListRequest implements UseCase.RequestValues{
        private int pageNumber;
        private String searchKey;


        public GetRepoListRequest(String searchKey,int pageNumber) {
            this.searchKey = searchKey;
            this.pageNumber = pageNumber;
        }

        public String getSearchKey() {
            return searchKey;
        }

        public int getPageNumber() {
            return pageNumber;
        }
    }

    public final class GetRepoListResponse implements UseCase.ResponseValue{

        private final List<GithubRepoDomainModel> mRepos;

        public GetRepoListResponse(List<GithubRepoDomainModel> repos) {
            mRepos = repos;
        }

        public List<GithubRepoDomainModel> getRepos() {
            return mRepos;
        }

    }

}

