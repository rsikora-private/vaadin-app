package com.sikorasoftware.webmail.service.login;

import org.springframework.stereotype.Service;

/**
 * Created by robertsikora on 31.12.2015.
 */

@Service
public class LoginService {

    public void login(final String username, final String password){
        if(!"admin".equals(username) && !"admin".equals(password)){
            throw new BadCredentialException("Bad credential");
        }
    }
}
