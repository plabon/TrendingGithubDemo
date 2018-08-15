package com.jukti.trendinggithubdemo.repoList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jukti.trendinggithubdemo.R;
import com.jukti.trendinggithubdemo.utils.ActiivtyUtils;

public class RepoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);

        RepoListFragment wordsFragment =
                (RepoListFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if (wordsFragment == null) {
            // Create the fragment
            wordsFragment = RepoListFragment.newInstance();
            ActiivtyUtils.addFragmentToActivity(
                    getSupportFragmentManager(), wordsFragment, R.id.container);
        }

    }
}
