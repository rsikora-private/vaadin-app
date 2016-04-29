package com.sikorasoftware.webmail.inbox;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by robertsikora on 06.01.2016.
 */
public class InboxService {

    private MailMessageRepository mailMessageRepository;
    private AccountService accountService;

    public void saveMessage(final Message mailMessage) {
        Assert.notNull(mailMessage);
        mailMessageRepository.save(mailMessage);
    }

    public void saveMessageForDefaultAccount(final Message mailMessage) {
        Assert.notNull(mailMessage);
        final Message dbMessage = mailMessageRepository.save(mailMessage); //single transaction
        final Optional<Account> defaultAccount = accountService.getDefaultAccount();  //single transaction
        Assert.isTrue(defaultAccount.isPresent(), "Cannot find default account.");
        final Account account = defaultAccount.get();
        account.getMessages().add(dbMessage.getId()); //on failure rollback here ???
        //single transaction
        accountService.save(account);
    }

    public List<Message> getMessagesForDefaultAccount() {
        final Optional<Account> defaultAccount = accountService.getDefaultAccount();
        if (defaultAccount.isPresent()) {
            final Account account = defaultAccount.get();
            return account.getMessages().stream().map(mailMessageRepository::findOne).collect(Collectors.toList());
        }
        //noinspection unchecked
        return Collections.EMPTY_LIST;
    }

    @Autowired
    public void setMailMessageRepository(final MailMessageRepository mailMessageRepository) {
        this.mailMessageRepository = mailMessageRepository;
    }

    public void setAccountService(final AccountService accountService) {
        this.accountService = accountService;
    }
}
