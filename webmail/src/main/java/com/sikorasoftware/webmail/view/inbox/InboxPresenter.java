package com.sikorasoftware.webmail.view.inbox;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.account.AccountService;
import com.sikorasoftware.webmail.common.component.table.MailTable;
import com.sikorasoftware.webmail.inbox.Email;
import com.sikorasoftware.webmail.inbox.InboxService;
import com.sikorasoftware.webmail.mvp.AbstractPresenter;
import com.vaadin.data.Property;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Field;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.VaadinComponent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
        if (accountOptional.isPresent()) {
            final List<TabSheet.Tab> addedTabs = new ArrayList<>();
            final Account account = accountOptional.get();
            final List<Email> emails = inboxService.getMessagesForDefaultAccount();
            addedTabs.add(view.loadMailsTab(emails, account.getName()));
            account.getBoxes().forEach(box
                    -> addedTabs.add(view.loadMailsTab(emails, box.getName())));
            addedTabs.forEach(tab -> ((MailTable) tab.getComponent()).addValueChangeListener(selectMessage()));
        }
    }

    private Button.ClickListener receiveMessages() {
        return event -> {
            Notification.show("starting ...");
            Notification.show("ending ...");
        };
    }

    private Property.ValueChangeListener selectMessage() {
        return event -> {
            final Field.ValueChangeEvent valueChangeEvent = (Field.ValueChangeEvent) event;
            if (valueChangeEvent != null) {
                final Email originalMailEmail = (Email) view.getMailTable().getValue();
                if (originalMailEmail != null) {
                    int index = view.getMailTable().getDataSet().indexOfId(originalMailEmail);
                    view.getMailTable().getDataSet().removeItem(originalMailEmail);
                    Email ms = new Email(
                            originalMailEmail.getId(),
                            originalMailEmail.getFrom(),
                            originalMailEmail.getSentDate(),
                            originalMailEmail.getSubject(),
                            false,
                            originalMailEmail.getContent());
                    view.getMailTable().getDataSet().addItemAt(index, ms);
                    markAsRed(originalMailEmail);
                    view.getMailTextarea().setContent(ms.getContent());
                }
            }
        };
    }

    private void markAsRed(final Email mailEmail) {
        if (mailEmail.isUnread()) {
            mailEmail.setUnread(false);
            inboxService.saveMessage(mailEmail);
        }
    }
}
