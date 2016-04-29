package com.sikorasoftware.webmail.inbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertsikora on 07.01.2016.
 */
public class EmailCreator {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailCreator.class);

    public Email createMessage(final javax.mail.Message message)
            throws MessagingException, IOException {
        final StringBuilder from = new StringBuilder();
        for (Address address : message.getFrom()) {
            if (from.length() > 0) {
                from.append(";");
            }
            from.append(address.toString());
        }
        //due to javax.mail.MessagingException: Unable to load BODYSTRUCTURE
        final MimeMessage mimeMessageWrapper = new MimeMessage((MimeMessage) message);
        return new Email(from.toString(), message.getSentDate(),
                message.getSubject(), getFinalContent(mimeMessageWrapper));
    }

    private List<EmailContent> getFinalContent(final Part part) throws MessagingException,
            IOException {
        final List<EmailContent> result = new ArrayList<>();
        final Object content = part.getContent();
        if (content instanceof String) {
            final String type = part.getContentType();
            result.add(new EmailContent(content.toString(), resolveContentType(type)));

        } else if (content instanceof Multipart) {
            final Multipart mp = (Multipart) content;
            for (int i = 0; i < mp.getCount(); i++) {
                final BodyPart bodyPart = mp.getBodyPart(i);
                result.addAll(getFinalContent(bodyPart));
            }

        } else {
            LOGGER.warn("{} not supported yet !!!!!", content.getClass().toString());
        }
        return result;
    }

    private EmailContent.ContentType resolveContentType(final String contentType) {
        return contentType.contains("text/plain")
                ? EmailContent.ContentType.TEXT
                : EmailContent.ContentType.HTML;
    }
}
