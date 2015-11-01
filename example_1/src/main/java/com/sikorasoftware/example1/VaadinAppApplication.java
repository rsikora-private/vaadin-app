package com.sikorasoftware.example1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"mvp.framework","com.sikorasoftware.example1"})
public class VaadinAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaadinAppApplication.class, args);
    }
}
