package com.branch.api_demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubDataUserResponse {

    private String login;

    private String name;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    private String location;

    private String email;

    private String url;

    @JsonProperty("created_at")
    private String createdAt;

    public String getLogin() {
        return login;
    }

    public GitHubDataUserResponse setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getName() {
        return name;
    }

    public GitHubDataUserResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public GitHubDataUserResponse setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public GitHubDataUserResponse setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public GitHubDataUserResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public GitHubDataUserResponse setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public GitHubDataUserResponse setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("login", login)
                .append("name", name)
                .append("avatarUrl", avatarUrl)
                .append("location", location)
                .append("email", email)
                .append("url", url)
                .append("createdAt", createdAt)
                .toString();
    }
}
