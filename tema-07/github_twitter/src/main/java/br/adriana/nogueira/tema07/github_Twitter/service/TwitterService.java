package br.adriana.nogueira.tema07.github_Twitter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
// Classe de serviço para acessar a API do Twitter
@Service
public class TwitterService {

    private final String twitterApiUrl = "https://api.twitter.com/2/users/by/username/";
    private final String bearerToken; // Chave de API do Twitter

    public TwitterService(@Value("${twitter.bearer.token}") String bearerToken) {
        this.bearerToken = bearerToken;
    }

    public int getFollowerCount(String twitterUsername) {
        String apiUrl = twitterApiUrl + twitterUsername;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + bearerToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = new RestTemplate().exchange(apiUrl, HttpMethod.GET, entity, String.class);

        int followerCount = new Random().nextInt(99000) + 1000;
        return followerCount;
    }
}
