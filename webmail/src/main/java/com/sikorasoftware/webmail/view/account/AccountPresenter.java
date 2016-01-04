package com.sikorasoftware.webmail.view.account;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.account.AccountService;
import com.sikorasoftware.webmail.mvp.Presenter;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.VaadinComponent;

/**
 * Created by robertsikora on 01.01.2016.
 */

@VaadinComponent
@UIScope
public class AccountPresenter implements Presenter {

    private AccountView view;

    @Autowired
    private AccountService accountService;

    @Override
    public void setView(final View view) {
        this.view = (AccountView) view;
    }

    @Override
    public void bind() {
        view.getAddNewButton().addClickListener(addNewAccount());
    }

    private Button.ClickListener addNewAccount(){
        return event -> view.addNewTab().addClickListener(saveAccount());
    }

    private Button.ClickListener saveAccount(){
        return event -> {
            Account account = new Account();
            account.setName("testowe");
            accountService.save(account);
        };
    }
}
