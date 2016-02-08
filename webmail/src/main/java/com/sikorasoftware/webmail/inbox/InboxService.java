package com.sikorasoftware.webmail.inbox;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.*;

/**
 * Created by robertsikora on 06.01.2016.
 */
public class InboxService {

    private MailMessageRepository   mailMessageRepository;
    private AccountService          accountService;

    public void saveMessage(final MailMessage mailMessage){
        Assert.notNull(mailMessage);

        mailMessageRepository.save(mailMessage);
    }

    public void saveMessageForDefaultAccount(final MailMessage mailMessage){
        Assert.notNull(mailMessage);

        final MailMessage dbMessage = mailMessageRepository.save(mailMessage); //single transaction
        final Optional<Account> defaultAccount = accountService.getDefaultAccount();  //single transaction

        final Account account = defaultAccount.get();
        Assert.notNull(account, "Account must exist here...something went wrong");

        account.getMessages().add(dbMessage.getId()); //on failure rollback here ???
        //single transaction
        accountService.save(account);
    }

    public List<MailMessage> getMessagesForDefaultAccount(){

        final Optional<Account> defaultAccount = accountService.getDefaultAccount();
        if(defaultAccount.isPresent()) {
            final Account account = defaultAccount.get();

            final List<MailMessage> result = new ArrayList<>();
            account.getMessages().forEach(id -> result.add(mailMessageRepository.findOne(id)));

            return result;
        }

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
