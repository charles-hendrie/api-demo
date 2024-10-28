package com.branch.api_demo.delgates

import com.branch.api_demo.delegates.GitHubDataDelegate
import com.branch.api_demo.models.GitHubDataRepoResponse
import com.branch.api_demo.models.GitHubDataUserResponse
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification
import spock.lang.Subject

class GitHubDataDelegateTest extends Specification {

    def mockRestTemplate = Mock(RestTemplate)

    @Subject
    def gitHubDataDelegate = new GitHubDataDelegate(mockRestTemplate)

    def "Get GitHub data for a user"() {

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
        def responseEntity = ResponseEntity<GitHubDataUserResponse>.ok(gitHubDataUserResponse)

        when:
        def response = gitHubDataDelegate.getGitHubDataUser(userName)

        then:
        1 * mockRestTemplate.exchange(
                "https://api.github.com/users/user_name",
                HttpMethod.GET,
                _ as HttpEntity,
                GitHubDataUserResponse.class) >> responseEntity
        response
        response.login == userName
        response.name == 'name'
        response.avatarUrl == 'avatar_url'
        response.location == 'location'
        response.email == 'email'
        response.url == 'url'
        response.createdAt == 'created_at'
    }

    def "Get GitHub data for a repository"() {

        given:
        def userName = 'user_name'

        and:
        def gitHubDataRepoResponse = new GitHubDataRepoResponse(name: 'name', htmlUrl: 'html_url')

        and:
        def responseEntity = ResponseEntity<GitHubDataRepoResponse>.ok([gitHubDataRepoResponse])

        when:
        def response = gitHubDataDelegate.getGitHubDataRepos(userName)

        then:
        1 * mockRestTemplate.exchange(
                "https://api.github.com/users/user_name/repos",
                HttpMethod.GET,
                _ as HttpEntity,
                _ as ParameterizedTypeReference<List<GitHubDataRepoResponse>>) >> responseEntity

        and:
        response
        response.size() == 1
        response[0].name == 'name'
        response[0].htmlUrl == 'html_url'
    }
}
