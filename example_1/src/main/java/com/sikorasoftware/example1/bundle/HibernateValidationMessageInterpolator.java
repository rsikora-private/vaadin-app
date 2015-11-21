package com.sikorasoftware.example1.bundle;

import java.util.Locale;
import javax.validation.MessageInterpolator;

import com.vaadin.server.VaadinSession;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;


/**
 * Created by robertsikora on 17.11.2015.
 */

public class HibernateValidationMessageInterpolator implements MessageInterpolator {

    private MessageSource messageSource;

    @Override
    public String interpolate(final String messageTemplate, final Context context) {
        messageSource = (MessageSource) SpringBeanProvider.getBean("jsr303Bundle");
        try {
            return messageSource.getMessage(messageTemplate, null, VaadinSession.getCurrent().getLocale());
        }catch (NoSuchMessageException ex){
            return "undefined";
        }
    }

    @Override
    public String interpolate(String messageTemplate, Context context, Locale locale) {
        messageSource = (MessageSource) SpringBeanProvider.getBean("jsr303Bundle");
        try{
            return messageSource.getMessage(messageTemplate, null, VaadinSession.getCurrent().getLocale());
        }catch (NoSuchMessageException ex){
            return "undefined";
        }
    }
}
