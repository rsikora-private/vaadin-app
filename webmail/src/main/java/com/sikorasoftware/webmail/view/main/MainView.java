package com.sikorasoftware.webmail.view.main;

import com.sikorasoftware.webmail.view.menu.WebmailMenu;
import com.vaadin.navigator.Navigator;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.VaadinComponent;

import javax.annotation.PostConstruct;

/*
 * Dashboard MainView is a simple HorizontalLayout that wraps the menu on the
 * left and creates a simple container for the navigator on the right.
 */

@VaadinComponent
@UIScope
public class MainView extends HorizontalLayout {

    @Autowired
    private SpringViewProvider viewProvider;

    @Autowired
    private WebmailMenu webmailMenu;

    private ComponentContainer content;

    @PostConstruct
    public void init() {
        setSizeFull();
        addStyleName("mainview");
        addComponent(webmailMenu);
        content = new CssLayout();
        content.addStyleName("view-content");
        content.setSizeFull();
        addComponent(content);
        setExpandRatio(content, 1.0f);
    }

    public void initializeNavigator() {
        final Navigator navigator = new Navigator(UI.getCurrent(), content);
        navigator.addProvider(viewProvider);
    }
}
