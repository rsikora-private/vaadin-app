package com.sikorasoftware.example1.bundle;

import com.vaadin.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

/**
 * Created by robertsikora on 09.11.2015.
 */
public final class I18N {

    private final static Logger LOGGER = LoggerFactory.getLogger(I18N.class);
    private final static MessageSource messageSource = (MessageSource)SpringBeanProvider.getBean("applicationBundle");

    private final static String DEFAULT_MESSAGE = "[lack of properties]";

    private I18N(){}

    private final static Locale pl_PL = new Locale("pl", "PL");

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

    public static Locale getLocale() {
        UI currentUI = UI.getCurrent();
        Locale locale = (currentUI == null ? null : currentUI.getLocale());
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return locale;
    }
}
