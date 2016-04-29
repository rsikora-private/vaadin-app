package com.sikorasoftware.webmail.inbox;

import com.sikorasoftware.webmail.common.listener.WebmailListener;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.mail.MailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.mail.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertsikora on 07.01.2016.
 */
public class EmailProcessor implements Processor {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailProcessor.class);

    private List<WebmailListener>   listeners = new ArrayList<>();
    private EmailCreator            emailCreator;

    @Override
    public void process(final Exchange exchange) throws Exception {
        final MailMessage in = (MailMessage) exchange.getIn();
        final Message message = in.getOriginalMessage();
        final Email email = emailCreator.createMessage(message);

        listeners.forEach(listener -> listener.listen(new InboxListenerContext(email)));

        LOGGER.info("Save a new mail message: {}", email.toString());
    }

    public void setEmailCreator(final EmailCreator emailCreator) {
        this.emailCreator = emailCreator;
    }

    public void setListeners(final List<WebmailListener> listeners) {
        Assert.notEmpty(listeners);
        this.listeners = listeners;
    }
}
