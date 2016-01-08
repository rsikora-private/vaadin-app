package com.sikorasoftware.webmail.view.inbox;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.account.AccountService;
import com.sikorasoftware.webmail.inbox.InboxService;
import com.sikorasoftware.webmail.mvp.AbstractPresenter;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.VaadinComponent;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by robertsikora on 06.01.2016.
 */

@VaadinComponent
@UIScope
public class InboxPresenter extends AbstractPresenter<InboxView> implements Serializable {

    @Autowired
    private InboxService inboxService;

    @Autowired
    private AccountService accountService;

    @Override
    protected void bind() {
        view.getReceiveButton().addClickListener(receiveMessages());
        onStart();
    }

    private void onStart() {

        final Optional<Account> accountOptional = accountService.getDefaultAccount();
        if(accountOptional.isPresent()) {
            view.loadMailsTab(inboxService.getMessagesForDefaultAccount(), accountOptional.get().getName());
        }
    }

    private Button.ClickListener receiveMessages(){
        return event -> {
            Notification.show("starting ...");


            Notification.show("ending ...");
        };
    }

}
