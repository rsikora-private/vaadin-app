package com.sikorasoftware.webmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.sikorasoftware.webmail"})
public class WebmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebmailApplication.class, args);
    }
}