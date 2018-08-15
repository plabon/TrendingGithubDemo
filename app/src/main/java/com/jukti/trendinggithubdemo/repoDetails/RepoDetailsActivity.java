package com.jukti.trendinggithubdemo.repoDetails;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jukti.trendinggithubdemo.R;
import com.jukti.trendinggithubdemo.models.GithubRepoModel;
import com.jukti.trendinggithubdemo.utils.ActiivtyUtils;

public class RepoDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_REPO_OBJECT = "REPO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        // Get the requested task id
        GithubRepoModel model = getIntent().getParcelableExtra(EXTRA_REPO_OBJECT);

        RepoDetailFragment repoDetailFragment = (RepoDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.container);

        if (repoDetailFragment == null) {
            repoDetailFragment = RepoDetailFragment.newInstance(model);

            ActiivtyUtils.addFragmentToActivity(getSupportFragmentManager(),
                    repoDetailFragment, R.id.container);

        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
