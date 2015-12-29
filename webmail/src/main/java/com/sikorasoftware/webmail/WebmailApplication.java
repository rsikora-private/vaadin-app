package com.sikorasoftware.webmail;

import mvp.framework.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({Config.CONTEXT_TO_UP, "com.sikorasoftware.webmail"})
public class WebmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebmailApplication.class, args);

    }
}