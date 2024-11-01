package com.branch.api_demo.controllers;

import com.branch.api_demo.models.GitHubDataResponse;
import com.branch.api_demo.services.GitHubDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubDataController {

    private final GitHubDataService gitHubDataService;

    private final static Logger LOGGER = LoggerFactory.getLogger(GitHubDataController.class);

    @Autowired
    public GitHubDataController(GitHubDataService gitHubDataService) {
        this.gitHubDataService = gitHubDataService;
    }

    @GetMapping("/api/hello")
    public void getHelloWorld() {
        System.out.println("hello world");
    }

    @GetMapping("/api/github/users/{username}")
    public ResponseEntity<GitHubDataResponse> getGitHubUser(@PathVariable String username) {
        try {
            return ResponseEntity.ok(gitHubDataService.getGitHubData(username));
        } catch (Exception e) {
            LOGGER.error("method=getGitHubUser details=failedRetrieveUserData username={}", username, e);
            return ResponseEntity.notFound().build();
        }
    }
}
