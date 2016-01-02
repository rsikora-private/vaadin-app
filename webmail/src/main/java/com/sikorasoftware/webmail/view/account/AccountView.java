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

    public void addNewTab(){
        tabSheet.addTab(buildAccountForm(), "New account");
    }

    private FormLayout buildAccountForm() {
        final FormLayout formLayout = new FormLayout();
        final TextField accountName = new TextField("Account name :");
        accountName.focus();
        final TextField accountEmail = new TextField("Email :");
        final PasswordField accountPassword = new PasswordField("Password :");
        final TextField accountImapHost = new TextField("IMAP host :");
        final TextField accountImapPort = new TextField("IMAP port :");
        final CheckBox accountImapSSL = new CheckBox("IMAP use SSL");
        final Button saveAccount = new Button("Save account");
        saveAccount.addStyleName(ValoTheme.BUTTON_PRIMARY);
        saveAccount.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        formLayout.setSizeFull();
        formLayout.setSpacing(true);
        formLayout.setMargin(true);

        formLayout.addComponents(accountName, accountEmail, accountPassword,
                accountImapHost, accountImapPort, accountImapSSL, saveAccount);

        formLayout.setComponentAlignment(accountImapSSL, Alignment.BOTTOM_LEFT);
        formLayout.setComponentAlignment(saveAccount, Alignment.BOTTOM_LEFT);

        return formLayout;
    }

    public Button getAddNewButton() {
        return addNewButton;
    }
}
