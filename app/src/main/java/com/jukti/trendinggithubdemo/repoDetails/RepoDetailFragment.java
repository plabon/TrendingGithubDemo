package com.jukti.trendinggithubdemo.repoDetails;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jukti.trendinggithubdemo.Injection;
import com.jukti.trendinggithubdemo.R;
import com.jukti.trendinggithubdemo.models.GithubRepoModel;
import com.jukti.trendinggithubdemo.repoList.GithubRepoListPresenter;
import com.jukti.trendinggithubdemo.repoList.RepoListAdapter;
import com.jukti.trendinggithubdemo.repoList.RepoListContract;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RepoDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RepoDetailFragment extends Fragment implements RepoDetailsContract.View {

    private static final String REPO_MODEL="repo_model";
    private GithubRepoDetailsPresenter mPresenter;
    private TextView titleText,idText,descriptionText,starCount,urlText,htmlUrl,watchesCount,languageText;
    private RecyclerView.LayoutManager mLayoutManager;

    public RepoDetailFragment() {


    }

    public static RepoDetailFragment newInstance(GithubRepoModel repo) {
        Bundle arguments = new Bundle();
        arguments.putParcelable(REPO_MODEL, repo);
        RepoDetailFragment fragment = new RepoDetailFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GithubRepoModel model = getArguments().getParcelable(REPO_MODEL);
        mPresenter = new GithubRepoDetailsPresenter(Injection.provideUseCaseHandler(),this);
        mPresenter.setModel(model);
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.repo_details_layout, container, false);

        idText=(TextView)view.findViewById(R.id.id_text);
        titleText=(TextView)view.findViewById(R.id.title_text);
        htmlUrl=(TextView)view.findViewById(R.id.html_url);
        urlText=(TextView)view.findViewById(R.id.url);
        descriptionText=(TextView)view.findViewById(R.id.description);
        starCount=(TextView)view.findViewById(R.id.stars_count);
        watchesCount =(TextView)view.findViewById(R.id.watchs_count);
        languageText = (TextView)view.findViewById(R.id.language);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
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
    public void showDescription(GithubRepoModel model) {
        idText.setText(getString(R.string.id_text,model.getId()+""));
        titleText.setText(model.getName());
        descriptionText.setText(model.getDescription());
        starCount.setText(getString(R.string.star_text,model.getStargazersCount()+""));
        watchesCount.setText(getString(R.string.watchers_text,model.getWatchers()+""));
        urlText.setText(model.getUrl());
        htmlUrl.setText(model.getHtmlUrl());
        languageText.setText(getString(R.string.language_text,model.getLanguage()));
    }

    @Override
    public void showLoadingProgress(boolean isShow) {

    }


    @Override
    public void showErrorMsg() {
        showLoadingProgress(false);
        Toast.makeText(getActivity(),"No data found",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void close() {
        getActivity().finish();
    }

    @Override
    public void setPresenter(RepoDetailsContract.Presenter presenter) {

    }

}
