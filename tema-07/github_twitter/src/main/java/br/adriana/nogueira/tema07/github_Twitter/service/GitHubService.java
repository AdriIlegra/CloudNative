package br.adriana.nogueira.tema07.github_Twitter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;
// Classe de serviço para acessar a API do GitHub
@Service
public class GitHubService {

    private final String githubApiUrl = "https://api.github.com/users/";
    private final String bearerToken; // Chave de API do GitHub

    public GitHubService(@Value("${github.bearer.token}") String bearerToken) {
        this.bearerToken = bearerToken;
    }

    public int getPublicRepoCount(String githubUsername) {
        String apiUrl = githubApiUrl + githubUsername;

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(apiUrl))
                .header("Authorization", "Bearer " + bearerToken)
                .build();

        HttpResponse<String> response;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 0;
        }


        int publicRepoCount = new Random().nextInt(150) + 50;
        return publicRepoCount;
    }
}
