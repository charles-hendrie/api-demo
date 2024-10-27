package com.branch.api_demo.controllers

import com.branch.api_demo.models.GitHubDataRepo
import com.branch.api_demo.models.GitHubDataResponse
import com.branch.api_demo.services.GitHubDataService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Subject

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class GitHubDataControllerTest extends Specification {

    def mockGitHubDataService = Mock(GitHubDataService)

    @Subject
    def gitHubDataController = new GitHubDataController(mockGitHubDataService)

    def mockMvc = standaloneSetup(gitHubDataController).build() as MockMvc

    def 'Get GitHub user'() {

        given:
        def userName = 'user_name'

        and:
        def gitHubDataResponse =
                new GitHubDataResponse(
                        userName: userName,
                        displayName: 'display_name',
                        avatar: 'avatar',
                        geoLocation: 'geo_location',
                        email: 'email',
                        url: 'url',
                        createdAt: 'created_at',
                        repos: [new GitHubDataRepo(name: 'name', url: 'url')])

        when:
        def response =
                mockMvc.perform(
                        get('/api/github/users/' + userName)
                                .contentType(MediaType.APPLICATION_JSON))
                        .andReturn()
                        .response

        then:
        1 * mockGitHubDataService.getGitHubData(userName) >> gitHubDataResponse

        and:
        response
        response.status == HttpStatus.OK.value()
        def json = response.getContentAsString()
        def responseData = new ObjectMapper().readValue(json, GitHubDataResponse.class)
        responseData
        responseData.userName == 'user_name'
        responseData.displayName == 'display_name'
        responseData.avatar == 'avatar'
        responseData.geoLocation == 'geo_location'
        responseData.email == 'email'
        responseData.url == 'url'
        responseData.createdAt == 'created_at'
        responseData.repos
        responseData.repos.size() == 1
        responseData.repos[0].name == 'name'
        responseData.repos[0].url == 'url'
    }
}
