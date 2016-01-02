package com.sikorasoftware.webmail.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by robertsikora on 09.11.2015.
 */

@Configuration
public class BundleConfiguration {

    public final static String APPLICATION_BUNDLE = "applicationBundle";

    @Bean(name = APPLICATION_BUNDLE)
    public MessageSource createResourceBundleMessageSource(){
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("bundle.application");
        return messageSource;
    }
/*
    public final static String JSR303_BUNDLE = "jsr303Bundle";

    @Bean(name = JSR303_BUNDLE)
    public MessageSource createJSR303ResourceBundle(){
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("bundle.ValidationMessages");
        return messageSource;
    }*/
}
