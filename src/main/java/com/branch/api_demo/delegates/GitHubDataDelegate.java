package com.branch.api_demo.delegates;

import com.branch.api_demo.models.GitHubDataRepoResponse;
import com.branch.api_demo.models.GitHubDataUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GitHubDataDelegate {

    private final RestTemplate restTemplate;

    @Autowired
    public GitHubDataDelegate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GitHubDataUserResponse getGitHubDataUser(final String username) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return restTemplate.exchange(
                        "https://api.github.com/users/" + username,
                        HttpMethod.GET,
                        new HttpEntity<>(httpHeaders),
                        GitHubDataUserResponse.class)
                .getBody();
    }

    public List<GitHubDataRepoResponse> getGitHubDataRepos(final String username) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return restTemplate.exchange(
                        "https://api.github.com/users/" + username + "/repos",
                        HttpMethod.GET,
                        new HttpEntity<>(httpHeaders),
                        new ParameterizedTypeReference<List<GitHubDataRepoResponse>>() {
                        })
                .getBody();
    }
}
