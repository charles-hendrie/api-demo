package com.branch.api_demo.services;

import com.branch.api_demo.delegates.GitHubDataDelegate;
import com.branch.api_demo.delegates.GitHubDataRepoResponse;
import com.branch.api_demo.delegates.GitHubDataUserResponse;
import com.branch.api_demo.models.GitHubDataRepo;
import com.branch.api_demo.models.GitHubDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GitHubDataService {

    private final GitHubDataDelegate gitHubDataDelegate;

    private static final Logger LOGGER = LoggerFactory.getLogger(GitHubDataService.class);

    @Autowired
    public GitHubDataService(GitHubDataDelegate gitHubDataDelegate) {
        this.gitHubDataDelegate = gitHubDataDelegate;
    }

    public GitHubDataResponse getGitHubData(final String username) {

        GitHubDataUserResponse gitHubDataUserResponse = gitHubDataDelegate.getGitHubDataUser(username);

        LOGGER.info("method=getGitHubData username={} gitHubDataUserResponse={}", username, gitHubDataUserResponse);

        List<GitHubDataRepoResponse> gitHubDataRepoResponses = gitHubDataDelegate.getGitHubDataRepos(username);

        LOGGER.info("method=getGitHubData username={} gitHubDataRepoResponses={}", username, gitHubDataRepoResponses);

        return new GitHubDataResponse()
                .setUserName(gitHubDataUserResponse.getLogin())
                .setDisplayName(gitHubDataUserResponse.getName())
                .setAvatar(gitHubDataUserResponse.getAvatarUrl())
                .setGeoLocation(gitHubDataUserResponse.getLocation())
                .setEmail(gitHubDataUserResponse.getEmail())
                .setUrl(gitHubDataUserResponse.getUrl())
                .setCreatedAt(gitHubDataUserResponse.getCreatedAt())
                .setRepos(transformRepos(gitHubDataRepoResponses));
    }

    private List<GitHubDataRepo> transformRepos(final List<GitHubDataRepoResponse> responseRepos) {

        List<GitHubDataRepo> repos = new ArrayList<>();

        for (GitHubDataRepoResponse gitHubDataRepoResponse : responseRepos) {
            repos.add(
                    new GitHubDataRepo()
                            .setName(gitHubDataRepoResponse.getName())
                            .setUrl(gitHubDataRepoResponse.getHtmlUrl()));
        }

        return repos;
    }
}
