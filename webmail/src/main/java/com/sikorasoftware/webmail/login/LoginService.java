package com.sikorasoftware.webmail.login;

import org.springframework.stereotype.Service;

/**
 * Created by robertsikora on 31.12.2015.
 */

@Service
public class LoginService {

    private final static String LOGIN       = "admin";
    private final static String PASSWORD    = "admin";

    public void login(final String username, final String password) {
        if (!LOGIN.equals(username)
                && !PASSWORD.equals(password)) {
            throw new BadCredentialException("Bad credential.");
        }
    }
}
