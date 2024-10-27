package com.branch.api_demo.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class GitHubDataRepo {

    private String name;

    private String url;

    public String getName() {
        return name;
    }

    public GitHubDataRepo setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public GitHubDataRepo setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("url", url)
                .toString();
    }
}
