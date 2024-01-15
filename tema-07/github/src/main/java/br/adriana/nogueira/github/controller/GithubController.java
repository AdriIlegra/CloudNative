package br.adriana.nogueira.github.controller;

import br.adriana.nogueira.github.model.GithubUserResponse;
import br.adriana.nogueira.github.service.GithubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class GithubController {

    private GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("{username}")
    public List<GithubUserResponse> getUsers(@PathVariable String username){
        return githubService.getUsers(username);

    }
}
