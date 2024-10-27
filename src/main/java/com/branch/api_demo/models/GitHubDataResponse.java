package com.branch.api_demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class GitHubDataResponse {

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("display_name")
    private String displayName;

    private String avatar;

    @JsonProperty("geo_location")
    private String geoLocation;

    private String email;

    private String url;

    @JsonProperty("created_at")
    private String createdAt;

    private List<GitHubDataRepo> repos;

    public String getUserName() {
        return userName;
    }

    public GitHubDataResponse setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public GitHubDataResponse setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public GitHubDataResponse setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public GitHubDataResponse setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public GitHubDataResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public GitHubDataResponse setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public GitHubDataResponse setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public List<GitHubDataRepo> getRepos() {
        return repos;
    }

    public GitHubDataResponse setRepos(List<GitHubDataRepo> repos) {
        this.repos = repos;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userName", userName)
                .append("displayName", displayName)
                .append("avatar", avatar)
                .append("geoLocation", geoLocation)
                .append("email", email)
                .append("url", url)
                .append("createdAt", createdAt)
                .append("repos", repos)
                .toString();
    }
}
