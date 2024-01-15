package br.adriana.nogueira.twitter.service;

import br.adriana.nogueira.twitter.exceptions.InvalidUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.OperationNotPermittedException;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;



@Service
public class TwitterService {

    private final Twitter twitter;

    private final TwitterTemplate twitterTemplate;


    @Autowired
    public TwitterService(Twitter twitter, TwitterTemplate twitterTemplate) {
        this.twitter = twitter;
        this.twitterTemplate = twitterTemplate;
    }


    public int getTweetCount(String username) throws InvalidUserException {
        try {
            return twitter.userOperations().getUserProfile(username).getStatusesCount();
        } catch (OperationNotPermittedException ex) {
            throw new InvalidUserException("Usuário inválido: " + ex.getMessage(), ex);
        }
    }
}
