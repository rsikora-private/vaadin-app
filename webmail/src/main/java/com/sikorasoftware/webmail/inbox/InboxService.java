package com.sikorasoftware.webmail.inbox;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by robertsikora on 06.01.2016.
 */

@Service
public class InboxService {

    @Autowired
    private EmailRepository         emailRepository;
    @Autowired
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
}
