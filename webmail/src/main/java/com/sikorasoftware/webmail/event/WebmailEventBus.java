package com.sikorasoftware.webmail.event;

/**
 * Created by robertsikora on 31.12.2015.
 */

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import org.springframework.stereotype.Component;

/**
 * A simple wrapper for Guava event bus. Defines static convenience methods for
 * relevant actions.
 *
 * It's thread-safety
 */

@Component
public class WebmailEventBus implements SubscriberExceptionHandler {

    private final EventBus eventBus = new EventBus(this);

    public void post(final Object event) {
        eventBus.post(event);
    }

    public void register(final Object subscriber){
        eventBus.register(subscriber);
    }

    public void unregister(final Object subscriber){
        eventBus.unregister(subscriber);
    }

    @Override
    public final void handleException(final Throwable exception,
                                      final SubscriberExceptionContext context) {
        exception.printStackTrace();
    }
}

