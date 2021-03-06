package com.sikorasoftware.webmail.view.login;

import com.sikorasoftware.webmail.event.WebmailEvent;
import com.sikorasoftware.webmail.event.WebmailEventBus;
import com.sikorasoftware.webmail.mvp.AbstractPresenter;
import com.sikorasoftware.webmail.login.LoginService;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.VaadinComponent;

/**
 * Created by robertsikora on 29.12.2015.
 */

@VaadinComponent
@UIScope
public class LoginPresenter extends AbstractPresenter<LoginView> implements Button.ClickListener {

    @Autowired
    private WebmailEventBus webmailEventBus;

    @Autowired
    private LoginService loginService;

    @Override
    public void buttonClick(final Button.ClickEvent event) {
        loginService.login(view.getUsername().getValue(), view.getPassword().getValue());
        webmailEventBus.post(new WebmailEvent.SuccessLoginEvent());
    }

    @Override
    public void bind() {
        view.getSigninButton().addClickListener(this);
    }
}
