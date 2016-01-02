package com.sikorasoftware.webmail.view.account;

import com.sikorasoftware.webmail.mvp.Presenter;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import org.vaadin.spring.annotation.VaadinComponent;

/**
 * Created by robertsikora on 01.01.2016.
 */

@VaadinComponent
@UIScope
public class AccountPresenter implements Presenter {

    private AccountView view;

    @Override
    public void setView(final View view) {
        this.view = (AccountView) view;
    }

    @Override
    public void bind() {
        view.getAddNewButton().addClickListener(addNewAccount());
    }

    private Button.ClickListener addNewAccount(){
        return event -> view.addNewTab();
    }
}
