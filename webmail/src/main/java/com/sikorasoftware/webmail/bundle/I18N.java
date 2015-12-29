package com.sikorasoftware.webmail.bundle;

import com.sikorasoftware.webmail.BundleConfiguration;
import com.vaadin.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by robertsikora on 09.11.2015.
 */

@Component
public class I18N {

    private final static Logger LOGGER = LoggerFactory.getLogger(I18N.class);

    private final static String DEFAULT_MESSAGE = "undefined";

    private static MessageSource messageSource ;

    @Qualifier(value = BundleConfiguration.APPLICATION_BUNDLE)
    @Autowired
    public void setMessageSource(final MessageSource messageSource){
        I18N.messageSource = messageSource;
    }

    public static String resolveMessage(final String code) {
        return resolveMessage(code, null);
    }

    public static String resolveMessage(final String code, final Object... args) {
        return resolveMessage(code, getLocale(), args);
    }

    public static String resolveMessage(final String code, Locale locale, final Object... args) {
        try {
            return messageSource.getMessage(code, args, locale);
        }catch (NoSuchMessageException ex){
            LOGGER.error("Cannot find message for code: {}", code);
            return DEFAULT_MESSAGE;
        }
    }

    private static Locale getLocale() {
        UI currentUI = UI.getCurrent();
        Locale locale = (currentUI == null ? null : currentUI.getLocale());
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return locale;
    }
}
