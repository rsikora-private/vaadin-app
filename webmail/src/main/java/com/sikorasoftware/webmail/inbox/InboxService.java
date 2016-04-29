package com.sikorasoftware.webmail.inbox;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by robertsikora on 06.01.2016.
 */
public class InboxService {

    private EmailRepository emailRepository;
    private AccountService          accountService;

    public void saveMessage(final Email email) {
        Assert.notNull(email);
        emailRepository.save(email);
    }

    public void saveMessageForDefaultAccount(final Email email) {
        Assert.notNull(email);
        final Email dbEmail = emailRepository.save(email); //single transaction
        final Optional<Account> defaultAccount = accountService.getDefaultAccount();  //single transaction
        Assert.isTrue(defaultAccount.isPresent(), "Cannot find default account.");
        final Account account = defaultAccount.get();
        account.getMessages().add(dbEmail.getId());
        //single transaction
        accountService.save(account);
    }

    public List<Email> getMessagesForDefaultAccount() {
        final Optional<Account> defaultAccount = accountService.getDefaultAccount();
        if (defaultAccount.isPresent()) {
            final Account account = defaultAccount.get();
            return account.getMessages().stream().map(emailRepository::findOne).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Autowired
    public void setEmailRepository(final EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public void setAccountService(final AccountService accountService) {
        this.accountService = accountService;
    }
}
