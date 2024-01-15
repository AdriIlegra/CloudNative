package br.adriana.nogueira.twitter.controller;

import br.adriana.nogueira.twitter.exceptions.InvalidUserException;
import br.adriana.nogueira.twitter.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    private final TwitterService twitterService;

    @Autowired
    public TwitterController(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GetMapping("/timeline")
    public String getTwitterTimeline(@RequestParam String username) {
        try {
            Integer tweetCount = twitterService.getTweetCount(username);
            return "Número de tweets do usuário " + username + ": " + tweetCount;
        } catch (InvalidUserException e) {
            return "Usuário inválido: " + e.getMessage();
        }
    }
}