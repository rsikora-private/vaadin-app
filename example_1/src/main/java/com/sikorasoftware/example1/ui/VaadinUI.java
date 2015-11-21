package com.sikorasoftware.example1.ui;

import com.sikorasoftware.example1.ui.add_user.AddUserViewImpl;
import com.sikorasoftware.example1.ui.all_users.AllUsersViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Locale;


/**
 * Created by robertsikora on 26.10.15.
 */

@Theme("valo")
@SpringUI(path = "example1")
public class VaadinUI extends UI {

    @Autowired
    private SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest request) {

        setLocale(VaadinSession.getCurrent().getLocale());

        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);

        final CssLayout navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        navigationBar.addComponent(createNavigationButton("All users", AllUsersViewImpl.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Add new user", AddUserViewImpl.VIEW_NAME));

        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        root.addComponent(viewContainer);
        root.setExpandRatio(viewContainer, 1.0f);

        final Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
        /*AllUsersViewImpl view1 = new AllUsersViewImpl();
        AddUserViewImpl view2 = new AddUserViewImpl();
        navigator.addView("", view1);
        navigator.addView(AddUserViewImpl.VIEW_NAME, view2);*/

        navigateTo(AddUserViewImpl.VIEW_NAME);

        Button changeLocal = new Button("EN/PL",
            t->{
                final Locale locale = UI.getCurrent().getLocale().equals(Locale.ENGLISH)? Locale.getDefault():Locale.ENGLISH;

                UI.getCurrent().setLocale(locale);
                VaadinSession.getCurrent().setLocale(locale);

                Page.getCurrent().reload();
            });

        navigationBar.addComponent(changeLocal);
        root.addComponent(navigationBar);
    }

    private Button createNavigationButton(final String caption, final String viewName) {
        final Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.addClickListener(event -> navigateTo(viewName));
        return button;
    }

    private void navigateTo(final String viewName){
        Assert.hasText(viewName);
        getUI().getNavigator().navigateTo(viewName);
    }
}
