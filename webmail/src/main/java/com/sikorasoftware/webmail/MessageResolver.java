package com.sikorasoftware.webmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Locale;

/**
 * Created by robertsikora on 11.05.2016.
 */

@Component
public class MessageResolver {
    @Autowired
    private static MessageSource messageSource;

    public final static String getMessage(final String key){
        Assert.notNull(key);
        return messageSource.getMessage(key, null, Locale.ENGLISH);
    }
}
