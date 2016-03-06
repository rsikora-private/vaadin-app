package com.sikorasoftware.webmail.view.login;

import com.sikorasoftware.webmail.layout.style.Styleable;
import com.sikorasoftware.webmail.mvp.ViewManager;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.VaadinComponent;

import javax.annotation.PostConstruct;

@VaadinComponent
@UIScope
public class LoginView extends VerticalLayout implements View, Styleable {

    private final static String LOGIN_PANEL_CSS = "login-panel";
    private final static String FIELDS_CSS = "fields";
    private final static String LABELS_CSS = "labels";

    private Button signin;
    private TextField username;
    private PasswordField password;

    @Autowired
    private ViewManager viewManager;

    @PostConstruct
    public void init() {
        viewManager.configure(this);
    }

    public LoginView() {
        setSizeFull();
        Component loginForm = buildLoginForm();
        addComponent(loginForm);
        setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
    }

    private Component buildLoginForm() {
        final VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSizeUndefined();
        loginPanel.setSpacing(true);
        Responsive.makeResponsive(loginPanel);
        loginPanel.addStyleName(LOGIN_PANEL_CSS);
        loginPanel.addComponent(buildLabels());
        loginPanel.addComponent(buildFields());
        loginPanel.addComponent(new CheckBox("Remember me", true));
        return loginPanel;
    }

    private Component buildFields() {
        HorizontalLayout fields = new HorizontalLayout();
        fields.setSpacing(true);
        fields.addStyleName(FIELDS_CSS);
        username = new TextField("Username");
        getUsername().setIcon(FontAwesome.USER);
        getUsername().addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        getUsername().focus();
        password = new PasswordField("Password");
        getPassword().setIcon(FontAwesome.LOCK);
        getPassword().addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        signin = new Button("Log In");
        signin.addStyleName(ValoTheme.BUTTON_PRIMARY);
        signin.setClickShortcut(KeyCode.ENTER);
        fields.addComponents(getUsername(), getPassword(), signin);
        fields.setComponentAlignment(signin, Alignment.BOTTOM_LEFT);
        return fields;
    }

    private Component buildLabels() {
        CssLayout labels = new CssLayout();
        labels.addStyleName(LABELS_CSS);
        Label welcome = new Label("Welcome to Webmail");
        welcome.setSizeUndefined();
        welcome.addStyleName(ValoTheme.LABEL_H4);
        welcome.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(welcome);
        return labels;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    @Override
    public String getStyle() {
        return "loginview";
    }

    public Button getSigninButton() {
        return signin;
    }

    public TextField getUsername() {
        return username;
    }

    public PasswordField getPassword() {
        return password;
    }
}
