package com.sikorasoftware.webmail.service.login;

/**
 * Created by robertsikora on 31.12.2015.
 */
public class BadCredentialException extends RuntimeException {

    public BadCredentialException(final String message){
        super(message);
    }
}
