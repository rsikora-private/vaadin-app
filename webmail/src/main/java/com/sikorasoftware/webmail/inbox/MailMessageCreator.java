package com.sikorasoftware.webmail.inbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertsikora on 07.01.2016.
 */
public class MailMessageCreator {

    private final static Logger LOGGER = LoggerFactory.getLogger(MailMessageCreator.class);

    public Message createMessage(final javax.mail.Message message)
            throws MessagingException, IOException {

        final StringBuilder from = new StringBuilder();
        for (Address address : message.getFrom()) {
            if(from.length() > 0){
                from.append(";");
            }
            from.append(address.toString());
        }

        //due to javax.mail.MessagingException: Unable to load BODYSTRUCTURE
        final MimeMessage mimeMessageWrapper = new MimeMessage((MimeMessage) message);

        final Message mailMessage = new Message(from.toString(), message.getSentDate(),
                message.getSubject(), getFinalContent(mimeMessageWrapper));

        return mailMessage;
    }

    private List<MailContent> getFinalContent(final Part part) throws MessagingException,
            IOException {

        final List<MailContent> result = new ArrayList<>();
        final Object content = part.getContent();

        if (content instanceof String) {

            final String type = part.getContentType();
            result.add(new MailContent(content.toString(), resolveContentType(type)));

        } else if (content instanceof Multipart){

            final Multipart mp = (Multipart) content;
            for(int i = 0; i< mp.getCount(); i++){

                final BodyPart bodyPart = mp.getBodyPart(i);
                result.addAll(getFinalContent(bodyPart));
            }

        } else{
            LOGGER.warn("{} not supported yet !!!!!", content.getClass().toString());
        }
        return result;
    }

    private MailContent.ContentType resolveContentType(final String contentType){

        return contentType.contains("text/plain")
                ? MailContent.ContentType.TEXT
                : MailContent.ContentType.HTML;
    }
}
