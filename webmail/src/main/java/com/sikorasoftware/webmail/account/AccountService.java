package com.sikorasoftware.webmail.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertsikora on 01.01.2016.
 */
public class AccountService {

    private AccountRepository accountRepository;

    public List<Account> getAllAcounts(){
        final List<Account> collection = new ArrayList<>();
        accountRepository.findAll().forEach(collection::add);
        return collection;
    }

    public void save(final Account account){
        Assert.notNull(account, "Account is required");

        accountRepository.save(account);
    }

    public void delete(final String accountId){

        accountRepository.delete(accountId);
    }

    @Autowired
    public void setAccountRepository(final AccountRepository repository) {
        this.accountRepository = repository;
    }
}
