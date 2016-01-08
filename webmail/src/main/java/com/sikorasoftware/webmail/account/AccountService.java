package com.sikorasoftware.webmail.account;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by robertsikora on 01.01.2016.
 */
public class AccountService {

    private AccountRepository accountRepository;

    public List<Account> getAllAccounts(){
        final List<Account> collection = new ArrayList<>();
        accountRepository.findAll().forEach(collection::add);
        return collection;
    }

    public void save(final Account account){
        Assert.notNull(account, "Account is required");

        accountRepository.save(account);
    }

    public void delete(final ObjectId accountId){

        accountRepository.delete(accountId);
    }

    public Optional<Account> getDefaultAccount(){
        final Iterator<Account> accountIterator = accountRepository.findAll().iterator();
        if(accountIterator.hasNext()){
            return Optional.of(accountIterator.next());
        }
        return Optional.empty();
    }

    @Autowired
    public void setAccountRepository(final AccountRepository repository) {
        this.accountRepository = repository;
    }
}
