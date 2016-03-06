package com.sikorasoftware.webmail.view.account;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.account.AccountService;
import com.sikorasoftware.webmail.common.component.textfield.TextFieldVisitatorEngine;
import com.sikorasoftware.webmail.common.component.textfield.ValidationVisibleVisitator;
import com.sikorasoftware.webmail.common.exception.ValidationException;
import com.sikorasoftware.webmail.mvp.AbstractPresenter;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.VaadinComponent;

import java.io.Serializable;
import java.util.List;

/**
 * Created by robertsikora on 01.01.2016.
 */

@VaadinComponent
@UIScope
public class AccountPresenter extends AbstractPresenter<AccountView> implements Serializable {

    private final static String TAB_CAPTION = "New account";

    @Autowired
    private AccountService accountService;

    @Override
    public void bind() {
        view.getAddNewButton().addClickListener(addNewAccount());
        view.getSaveAccountButton().addClickListener(saveAccount());
        view.getDeleteButton().addClickListener(deleteAccount());
        onStart();
    }

    private void onStart() {
        loadTabs();
    }

    private void loadTabs() {
        final List<Account> accountList = accountService.getAllAccounts();
        view.removeAllTabs();
        accountList.forEach(account -> view.addTab(account.getName(), account, false));
    }

    private Button.ClickListener addNewAccount() {
        return event -> view.addTab(TAB_CAPTION, new Account(), true);
    }

    private Button.ClickListener saveAccount() {
        return event -> {
            final BeanFieldGroup<Account> tabBinder = view.getCurrentTabBinder();
            try {
                TextFieldVisitatorEngine.visit(view.getSelectedAccountForm(), new ValidationVisibleVisitator(true));
                tabBinder.commit();
            } catch (FieldGroup.CommitException e) {
                throw new ValidationException("validation error", e);
            }
            accountService.save(tabBinder.getItemDataSource().getBean());
            loadTabs();
        };
    }

    private Button.ClickListener deleteAccount() {
        return event -> {
            final BeanFieldGroup<Account> tabBinder = view.getCurrentTabBinder();
            final Account selectedAccount = tabBinder.getItemDataSource().getBean();
            if (selectedAccount.getId() != null) {
                accountService.deleteByObjectId(selectedAccount.getId());
            }
            loadTabs();
        };
    }
}
