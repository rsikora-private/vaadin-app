package com.sikorasoftware.webmail;

import com.google.common.eventbus.Subscribe;
import com.sikorasoftware.webmail.config.AppConfig;
import com.sikorasoftware.webmail.event.WebmailEvent;
import com.sikorasoftware.webmail.event.WebmailEventBus;
import com.sikorasoftware.webmail.view.login.LoginView;
import com.sikorasoftware.webmail.view.main.MainView;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PreDestroy;
import java.util.Locale;

/**
 * Created by robertsikora on 26.10.15.
 */

@Theme(AppConfig.APP_THEME)
@SpringUI(path = AppConfig.APP_URI)
public class WebmailUI extends UI {

    @Autowired
    private WebmailEventBus webmailEventBus;

    @Autowired
    private LoginView       loginView;

    @Autowired
    private MainView        mainView;

    @Override
    protected void init(VaadinRequest request) {

        setLocale(Locale.ENGLISH);
        webmailEventBus.register(this);

        setContent(loginView);
        addStyleName(loginView.getStyle());
    }

    @Subscribe
    public void onSuccessLoginEvent(final WebmailEvent.SuccessLoginEvent event) {
        mainView.initializeNavigator();
        setContent(mainView);
    }

    @Subscribe
    public void onLogOutEvent(final WebmailEvent.LoggedOutEvent event) {
        setContent(loginView);

        //mainView clear up ??
    }

    @PreDestroy
    public void onDestroy(){
        webmailEventBus.unregister(this);
    }
}
