package com.sikorasoftware.webmail.view.account;

import com.sikorasoftware.webmail.mvp.ViewManager;
import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by robertsikora on 31.12.2015.
 */

@SpringView(name = AccountView.NAME)
public class AccountView extends FormLayout implements View {

    public final static String NAME = "account";

    @Autowired
    private ViewManager viewManager;

    @PostConstruct
    public void init() {
        viewManager.configure(this);
    }

    private TabSheet tabSheet;
    private Button   addNewButton;
    private Button   saveAccountButton;

    public AccountView(){
        buildLayout();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    private void buildLayout() {

        addNewButton = new Button("Add new account");
        addNewButton.addStyleName(ValoTheme.BUTTON_SMALL);
        tabSheet = new TabSheet();
        tabSheet.setHeight(500, Unit.PIXELS);
        tabSheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
        tabSheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

        addComponents(getAddNewButton(), tabSheet);
    }

    public Button addNewTab(final String tabCaption){
        tabSheet.addTab(buildAccountForm(), tabCaption);
        return saveAccountButton;
    }

    private FormLayout buildAccountForm() {
        final FormLayout formLayout = new FormLayout();
        final TextField name = new TextField("Account name :");
        name.focus();
        final TextField email = new TextField("Email :");
        final PasswordField password = new PasswordField("Password :");
        final TextField imapHost = new TextField("IMAP host :");
        final TextField imapPort = new TextField("IMAP port :");
        final CheckBox imapSSL = new CheckBox("IMAP use SSL");
        saveAccountButton = new Button("Save account");
        saveAccountButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        saveAccountButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        formLayout.setSizeFull();
        formLayout.setSpacing(true);
        formLayout.setMargin(true);

        formLayout.addComponents(name, email, password,
                imapHost, imapPort, imapSSL, saveAccountButton);

        return formLayout;
    }

    public Button getAddNewButton() {
        return addNewButton;
    }
}
