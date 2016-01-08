package com.sikorasoftware.webmail.inbox;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

/**
 * Created by robertsikora on 07.01.2016.
 */
public class MailMessageCreator {

    public com.sikorasoftware.webmail.inbox.MailMessage createMessage(final Message message)
            throws MessagingException, IOException {

        final StringBuilder from = new StringBuilder();
        final Address[] addressesIn = message.getFrom();

        for (Address address : addressesIn) {
            if(from.length() > 0){
                from.append(";");
            }
            from.append(address.toString());
        }

        final Object content = new MimeMessage((MimeMessage) message).getContent();

        return new com.sikorasoftware.webmail.inbox.MailMessage(from.toString(),
                message.getSentDate(), message.getSubject(), content.toString());
    }
}
