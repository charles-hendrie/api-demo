package com.branch.api_demo.services

import com.branch.api_demo.delegates.GitHubDataDelegate
import com.branch.api_demo.models.GitHubDataRepoResponse
import com.branch.api_demo.models.GitHubDataUserResponse
import spock.lang.Specification
import spock.lang.Subject

class GitHubDataServiceTest extends Specification {

    def mockGitHubDataDelegate = Mock(GitHubDataDelegate)

    @Subject
    def gitHubDataService = new GitHubDataService(mockGitHubDataDelegate)

    def 'Get GitHub data'() {

        given:
        def userName = 'user_name'

        and:
        def gitHubDataUserResponse =
                new GitHubDataUserResponse(
                        login: userName,
                        name: 'name',
                        avatarUrl: 'avatar_url',
                        location: 'location',
                        email: 'email',
                        url: 'url',
                        createdAt: 'created_at')

        and:
        def gitHubDataRepoResponse = new GitHubDataRepoResponse(name: 'name', htmlUrl: 'html_url')

        when:
        def gitHubDataResponse = gitHubDataService.getGitHubData(userName)

        then:
        1 * mockGitHubDataDelegate.getGitHubDataUser(userName) >> gitHubDataUserResponse
        1 * mockGitHubDataDelegate.getGitHubDataRepos(userName) >> [gitHubDataRepoResponse]

        and:
        gitHubDataResponse
        gitHubDataResponse.userName == userName
        gitHubDataResponse.displayName == 'name'
        gitHubDataResponse.avatar == 'avatar_url'
        gitHubDataResponse.geoLocation == 'location'
        gitHubDataResponse.url == 'url'
        gitHubDataResponse.createdAt == 'created_at'
        gitHubDataResponse.repos
        gitHubDataResponse.repos.size() == 1
        gitHubDataResponse.repos[0].name == 'name'
        gitHubDataResponse.repos[0].url == 'html_url'
    }
}
