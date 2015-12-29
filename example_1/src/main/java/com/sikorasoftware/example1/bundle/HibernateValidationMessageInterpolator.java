package com.sikorasoftware.example1.bundle;

import java.util.Locale;
import javax.validation.MessageInterpolator;

import com.sikorasoftware.example1.BundleConfiguration;
import com.sikorasoftware.example1.SpringBeanProvider;
import com.vaadin.server.VaadinSession;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;


/**
 * Created by robertsikora on 17.11.2015.
 *
 * TO-DO add cache support
 */

//@Configurable
public class HibernateValidationMessageInterpolator implements MessageInterpolator {

    private final static String UNDEFINED = "undefined";

    private MessageSource messageSource;

    @Override
    public String interpolate(final String messageTemplate, final Context context) {
        messageSource = (MessageSource) SpringBeanProvider.getBean(BundleConfiguration.JSR303_BUNDLE);
        try {
            return messageSource.getMessage(messageTemplate, null, VaadinSession.getCurrent().getLocale());
        }catch (NoSuchMessageException ex){
            return UNDEFINED;
        }
    }

    @Override
    public String interpolate(String messageTemplate, Context context, Locale locale) {
        messageSource = (MessageSource) SpringBeanProvider.getBean(BundleConfiguration.JSR303_BUNDLE);
        try{
            return messageSource.getMessage(messageTemplate, null, VaadinSession.getCurrent().getLocale());
        }catch (NoSuchMessageException ex){
            return UNDEFINED;
        }
    }
}
