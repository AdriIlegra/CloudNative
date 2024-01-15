package br.adriana.nogueira.twitter.exceptions;

import org.springframework.social.OperationNotPermittedException;

public class InvalidUserException extends Throwable {

    public InvalidUserException(String e, OperationNotPermittedException ex) {

    }
}
