package br.adriana.nogueira.github.service;

import br.adriana.nogueira.github.model.GithubUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class GithubService {
    public List<GithubUserResponse> getUsers(String username) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GithubUserResponse[]> response = restTemplate.getForEntity(
                "https://api.github.com/users/" + username + "/repos",
                GithubUserResponse[].class);
        return Arrays.asList(response.getBody());
    }

}
