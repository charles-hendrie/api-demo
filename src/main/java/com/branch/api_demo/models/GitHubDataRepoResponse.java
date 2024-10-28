package com.branch.api_demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubDataRepoResponse {

    private String name;

    @JsonProperty("html_url")
    private String htmlUrl;

    public String getName() {
        return name;
    }

    public GitHubDataRepoResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public GitHubDataRepoResponse setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("htmlUrl", htmlUrl)
                .toString();
    }
}
