package br.adriana.nogueira.tema07.github_Twitter.controller;


import br.adriana.nogueira.tema07.github_Twitter.service.GitHubService;
import br.adriana.nogueira.tema07.github_Twitter.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// Classe Controller para o microservice
@RestController
public class MicroserviceController {

    private final TwitterService twitterService;
    private final GitHubService gitHubService;

    @Autowired
    public MicroserviceController(TwitterService twitterService, GitHubService gitHubService) {
        this.twitterService = twitterService;
        this.gitHubService = gitHubService;
    }

    @GetMapping("/totalizadores")
    public ResponseEntity<Map<String, Integer>> getTotalizadores(
            @RequestParam("twitter") String twitterUsername,
            @RequestParam("github") String githubUsername
    ) {
        Map<String, Integer> totalizadores = new HashMap<>();

        // Obter o número de seguidores do usuário no Twitter
        int followerCount = twitterService.getFollowerCount(twitterUsername);
        totalizadores.put("seguidores_twitter", followerCount);

        // Obter o número de repositórios públicos do usuário no GitHub
        int publicRepoCount = gitHubService.getPublicRepoCount(githubUsername);
        totalizadores.put("repositorios_github", publicRepoCount);

        return ResponseEntity.ok(totalizadores);
    }
}
