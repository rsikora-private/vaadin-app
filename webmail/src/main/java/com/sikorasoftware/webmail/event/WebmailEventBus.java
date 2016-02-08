package com.sikorasoftware.webmail.event;

/**
 * Created by robertsikora on 31.12.2015.
 */

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * It's thread-safety
 */

@Component
public class WebmailEventBus implements SubscriberExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebmailEventBus.class);

    private final EventBus eventBus = new EventBus(this);

    public void post(final Object event) {
        Assert.notNull(event, "Event is required.");

        eventBus.post(event);

        LOGGER.debug("Event {} posted", event);
    }

    public void register(final Object subscriber){
        Assert.notNull(subscriber, "Subscriber is required.");

        eventBus.register(subscriber);

        LOGGER.debug("Subscriber {} registered", subscriber);
    }

    public void unregister(final Object subscriber){
        Assert.notNull(subscriber, "Subscriber is required.");

        eventBus.unregister(subscriber);

        LOGGER.debug("Subscriber {} unregistered", subscriber);
    }

    @Override
    public final void handleException(final Throwable exception,
                                      final SubscriberExceptionContext context) {

        LOGGER.error(exception.getMessage(), exception);
    }
}

