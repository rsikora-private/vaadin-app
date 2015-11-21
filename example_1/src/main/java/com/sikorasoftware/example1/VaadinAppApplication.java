package com.sikorasoftware.example1;

import mvp.framework.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({Config.CONTEXT_TO_UP, "com.sikorasoftware.example1"})
public class VaadinAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaadinAppApplication.class, args);

    }
}