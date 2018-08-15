package java.jukti.trendingGithubDemo.domain.models;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class GithubRepoDomainModel {
    private long id;
    private String htmlUrl;
    private String url;
    private String name;
    private String language;
    private String description;
    private int watchsCount;
    private String nodeId;
    private int stargazersCount;
    private int watchers;

    public GithubRepoDomainModel(long id, String htmlUrl, String url, String name, String language, String description, int watchsCount, String nodeId, int stargazersCount, int watchers) {
        this.id = id;
        this.htmlUrl = htmlUrl;
        this.url = url;
        this.name = name;
        this.language = language;
        this.description = description;
        this.watchsCount = watchsCount;
        this.nodeId = nodeId;
        this.stargazersCount = stargazersCount;
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


    @Override
    public String toString() {
        return "GithubRepoDomainModel{" +
                "id=" + id +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", watchsCount=" + watchsCount +
                ", nodeId='" + nodeId + '\'' +
                ", stargazersCount=" + stargazersCount +
                ", watchers=" + watchers +
                '}';
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }
}
