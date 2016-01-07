package com.sikorasoftware.webmail.inbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Created by robertsikora on 06.01.2016.
 */
public class InboxService {

    private MailMessageRepository mailMessageRepository;

    public void saveMessage(final MailMessage mailMessage){
        Assert.notNull(mailMessage);

        mailMessageRepository.save(mailMessage);
    }

    @Autowired
    public void setMailMessageRepository(final MailMessageRepository mailMessageRepository) {
        this.mailMessageRepository = mailMessageRepository;
    }
}
