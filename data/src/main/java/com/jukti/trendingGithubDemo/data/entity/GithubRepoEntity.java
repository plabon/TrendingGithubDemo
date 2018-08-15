package com.jukti.trendingGithubDemo.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class GithubRepoEntity {

    @SerializedName("id")
    private long id;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;
    @SerializedName("language")
    private String language;
    @SerializedName("description")
    private String description;
    @SerializedName("watchers_count")
    private int watchsCount;
    @SerializedName("node_id")
    private String nodeId;
    @SerializedName("stargazers_count")
    private int stargazersCount;
    @SerializedName("watchers")
    private int watchers;

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWatchsCount() {
        return watchsCount;
    }

    public void setWatchsCount(int watchsCount) {
        this.watchsCount = watchsCount;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }


}
