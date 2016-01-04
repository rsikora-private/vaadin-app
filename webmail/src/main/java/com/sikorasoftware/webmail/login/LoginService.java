package com.sikorasoftware.webmail.login;

/**
 * Created by robertsikora on 31.12.2015.
 */
public class LoginService {

    public void login(final String username, final String password){
        if(!"admin".equals(username) && !"admin".equals(password)){
            throw new BadCredentialException("Bad credential");
        }
    }
}
