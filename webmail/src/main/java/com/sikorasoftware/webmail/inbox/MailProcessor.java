package com.sikorasoftware.webmail.inbox;

import org.apache.camel.*;
import org.apache.camel.component.mail.MailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;

/**
 * Created by robertsikora on 07.01.2016.
 */
public class MailProcessor implements Processor {

    private final static Logger LOGGER = LoggerFactory.getLogger(MailProcessor.class);

    private InboxService inboxService;
    private MailMessageCreator mailMessageCreator;

    @Override
    public void process(final Exchange exchange) throws Exception {
        final MailMessage in = (MailMessage) exchange.getIn();
        final Message originalJavaxMailMessage = in.getOriginalMessage();
        final com.sikorasoftware.webmail.inbox.Message mailMessage = mailMessageCreator.createMessage(originalJavaxMailMessage);
        inboxService.saveMessageForDefaultAccount(mailMessage);
        LOGGER.info("Save a new mail message: {}", mailMessage.toString());
    }

    public void setInboxService(final InboxService inboxService) {
        this.inboxService = inboxService;
    }

    public void setMailMessageCreator(final MailMessageCreator mailMessageCreator) {
        this.mailMessageCreator = mailMessageCreator;
    }
}
