package com.sikorasoftware.webmail.event;

/**
 * Created by robertsikora on 31.12.2015.
 */

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * It's thread-safety
 */

@Component
public class WebmailEventBus implements SubscriberExceptionHandler {

    private final EventBus eventBus = new EventBus(this);

    public void post(final Object event) {
        Assert.notNull(event);

        eventBus.post(event);
    }

    public void register(final Object subscriber){
        Assert.notNull(subscriber);

        eventBus.register(subscriber);
    }

    public void unregister(final Object subscriber){
        Assert.notNull(subscriber);

        eventBus.unregister(subscriber);
    }

    @Override
    public final void handleException(final Throwable exception,
                                      final SubscriberExceptionContext context) {
        exception.printStackTrace();
    }
}

