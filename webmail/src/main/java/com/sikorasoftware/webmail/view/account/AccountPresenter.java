package com.sikorasoftware.webmail.view.account;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.account.AccountService;
import com.sikorasoftware.webmail.mvp.AbstractPresenter;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.VaadinComponent;

/**
 * Created by robertsikora on 01.01.2016.
 */

@VaadinComponent
@UIScope
public class AccountPresenter extends AbstractPresenter<AccountView> {

    private final static String TAB_CAPTION = "New account";

    @Autowired
    private AccountService accountService;

    @Override
    public void bind() {
        view.getAddNewButton().addClickListener(addNewAccount());
    }

    private Button.ClickListener addNewAccount(){
        return event -> view.addNewTab(TAB_CAPTION).addClickListener(saveAccount());
    }

    private Button.ClickListener saveAccount(){
        return event -> {
            Account account = new Account();
            account.setName("testowe");
            accountService.save(account);
        };
    }
}
