package com.sikorasoftware.example1;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by robertsikora on 09.11.2015.
 */

@Configuration
public class BundleConfiguration {

    @Bean(name = "applicationBundle")
    public MessageSource createResourceBundleMessageSource(){
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("bundle.application");
        return messageSource;
    }

    @Bean(name = "jsr303Bundle")
    public MessageSource createJSR303ResourceBundle(){
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("bundle.ValidationMessages");
        return messageSource;
    }
}
