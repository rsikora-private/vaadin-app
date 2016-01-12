package com.sikorasoftware.webmail.view.account;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.mvp.ViewManager;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by robertsikora on 31.12.2015.
 */

@SpringView(name = AccountView.NAME)
public class AccountView extends FormLayout implements View, Serializable {

    public final static String NAME = "account";

    private final Map<TabSheet.Tab, BeanFieldGroup<Account>> TAB_BINDING = new HashMap<>();

    @Autowired
    private ViewManager viewManager;

    @PostConstruct
    public void init() {
        viewManager.configure(this);
    }

    private final TabSheet        tabSheet = new TabSheet();
    {
        tabSheet.setHeight(500, Unit.PIXELS);
        tabSheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
    }

    private final Button          addNewButton = new Button("Add new account");
    {
        addNewButton.addStyleName(ValoTheme.BUTTON_SMALL);
    }
    private final Button          saveAccountButton = new Button("Save account");
    {
        saveAccountButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        saveAccountButton.addStyleName(ValoTheme.BUTTON_SMALL);
    }
    private final Button          deleteButton = new Button("Delete account");
    {
        deleteButton.addStyleName(ValoTheme.BUTTON_DANGER);
        deleteButton.addStyleName(ValoTheme.BUTTON_SMALL);
    }

    public AccountView(){
        buildLayout();
    }

    private void buildLayout() {
        final HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponents(addNewButton, saveAccountButton, deleteButton);

        addComponents(horizontalLayout, tabSheet);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    public void removeAllTabs(){
        TAB_BINDING.keySet().forEach(tabSheet::removeTab);
        TAB_BINDING.clear();
    }

    public void addTab(final String tabCaption, final Account account, boolean selectTab){

        final AccountForm accountForm = new AccountForm();
        final BoxForm boxForm = new BoxForm(account.getBoxes());

        final VerticalLayout verticalLayout = new VerticalLayout();

        Panel accountPanel = new Panel();
        accountPanel.setCaption("Server settings");
        accountPanel.setContent(accountForm);

        Panel boxPanel = new Panel();
        boxPanel.setCaption("Boxes");
        boxPanel.setContent(boxForm);

        verticalLayout.addComponents(accountPanel, boxPanel);

        final TabSheet.Tab tab = tabSheet.addTab(verticalLayout, tabCaption);
        if(selectTab) {
            tabSheet.setSelectedTab(tab);
        }
        final BeanFieldGroup<Account> accountBeanFieldGroup = BeanFieldGroup.bindFieldsBuffered(account, accountForm);
        TAB_BINDING.put(tab, accountBeanFieldGroup);
    }

    public BeanFieldGroup getCurrentTabBinder(){
        final TabSheet.Tab selectedTab = tabSheet.getTab(tabSheet.getSelectedTab());
        final BeanFieldGroup<Account> binder = TAB_BINDING.get(selectedTab);
        Assert.notNull(binder);
        return binder;
    }

    public AccountForm getSelectedAccountForm(){
        return (AccountForm) ((Panel)((VerticalLayout) tabSheet.getSelectedTab()).getComponent(0)).getContent();
    }

    public Button getAddNewButton() {
        return addNewButton;
    }

    public Button getSaveAccountButton() {
        return saveAccountButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
}
