package com.jukti.trendinggithubdemo.repoList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jukti.trendinggithubdemo.R;
import com.jukti.trendinggithubdemo.models.GithubRepoModel;

import java.util.List;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoViewHolder>{
    List<GithubRepoModel> repos;
    GithubRepoListPresenter mPresenter;

    public RepoListAdapter(List<GithubRepoModel> repos, GithubRepoListPresenter presenter) {
        this.repos = repos;
        this.mPresenter = presenter;
    }



    public void setRepos(List<GithubRepoModel> repos) {
        this.repos = repos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repo_list_item, parent, false);
        return new RepoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, final int position) {
        final GithubRepoModel model=repos.get(position);
        holder.updateItem(model);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onClickRepoItem(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }




    static final class RepoViewHolder extends RecyclerView.ViewHolder{
        TextView repoTitleText, repoUrlText;

        public RepoViewHolder(View itemView) {
            super(itemView);
            repoTitleText = (TextView) itemView.findViewById(R.id.english_word);
            repoUrlText = (TextView) itemView.findViewById(R.id.bangla_word);
        }

        public void updateItem(GithubRepoModel repoModel){
            repoTitleText.setText(repoModel.getName());
            repoUrlText.setText(repoModel.getUrl());

        }
    }
}
