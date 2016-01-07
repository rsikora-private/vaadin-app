package com.sikorasoftware.webmail.inbox;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by robertsikora on 06.01.2016.
 */
public interface MailMessageRepository extends CrudRepository<MailMessage, String> {
}
