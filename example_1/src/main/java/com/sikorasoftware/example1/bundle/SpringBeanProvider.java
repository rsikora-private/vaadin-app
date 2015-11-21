package com.sikorasoftware.example1.bundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Objects;


/**
 * Created by robertsikora on 09.11.2015.
 */
@Component
public class SpringBeanProvider implements ApplicationContextAware, InitializingBean {

    protected static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        SpringBeanProvider.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Objects.requireNonNull(applicationContext, "Failed to autowire 'ApplicationContext'");
    }

    public static Object getBean(final String beanName) {
        Assert.hasText(beanName);
        return applicationContext.getBean(normalizeBeanName(beanName));
    }

    private static String normalizeBeanName(final String input){
        return String.valueOf(input.charAt(0)).toLowerCase().concat(input.substring(1, input.length()));
    }
}
