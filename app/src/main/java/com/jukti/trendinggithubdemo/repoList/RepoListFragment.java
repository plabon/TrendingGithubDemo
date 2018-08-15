package com.jukti.trendinggithubdemo.repoList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.jukti.trendinggithubdemo.Injection;
import com.jukti.trendinggithubdemo.R;
import com.jukti.trendinggithubdemo.models.GithubRepoModel;
import com.jukti.trendinggithubdemo.repoDetails.RepoDetailsActivity;
import com.jukti.trendinggithubdemo.utils.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RepoListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RepoListFragment extends Fragment implements RepoListContract.View {


    private GithubRepoListPresenter mPresenter;
    private RecyclerView repoRecyClerView;
    private ProgressBar loadingProgress;
    private List<GithubRepoModel> repoModels;
    private RepoListAdapter mRepoAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public RepoListFragment() {


    }


    // TODO: Rename and change types and number of parameters
    public static RepoListFragment newInstance() {
        RepoListFragment fragment = new RepoListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new GithubRepoListPresenter(Injection.provideUseCaseHandler(),Injection.provideGetRepos(getActivity()),this);
        repoModels = new ArrayList<>();
        mRepoAdapter = new RepoListAdapter(repoModels,mPresenter);
        mLayoutManager = new LinearLayoutManager(getActivity());
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_repo_list, container, false);
        repoRecyClerView = view.findViewById(R.id.word_recyclerview);
        loadingProgress = view.findViewById(R.id.loading_progress);
        repoRecyClerView.setLayoutManager(mLayoutManager);
        repoRecyClerView.setAdapter(mRepoAdapter);
        if(Utility.isNetworkAvailable(getActivity()))
            mPresenter.getAllRepos();
        else
            showNoInternetConnection();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showRepos(List<GithubRepoModel> repos) {
        repoModels.clear();
        repoModels.addAll(repos);
        showLoadingProgress(false);
        mRepoAdapter.setRepos(repoModels);

    }



    @Override
    public void showLoadingProgress(boolean isShow) {
        if(isShow){
            loadingProgress.setVisibility(View.VISIBLE);
            repoRecyClerView.setVisibility(View.GONE);
        }else{
            loadingProgress.setVisibility(View.GONE);
            repoRecyClerView.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void showErrorMsg() {
        showLoadingProgress(false);
        Toast.makeText(getActivity(),"No data found",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void startDetailActivity(GithubRepoModel model) {
        Intent intent = new Intent(getContext(), RepoDetailsActivity.class);
        intent.putExtra(RepoDetailsActivity.EXTRA_REPO_OBJECT, model);
        startActivity(intent);
    }

    @Override
    public void showNoInternetConnection() {
        loadingProgress.setVisibility(View.GONE);
        Toast.makeText(getActivity(),"Please check your internet connection!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(RepoListContract.Presenter presenter) {

    }


}
