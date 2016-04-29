package com.sikorasoftware.webmail.view.inbox;

import com.sikorasoftware.webmail.common.component.table.MailTable;
import com.sikorasoftware.webmail.common.component.textarea.MailTextarea;
import com.sikorasoftware.webmail.inbox.Email;
import com.sikorasoftware.webmail.mvp.ViewManager;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

/**
 * Created by robertsikora on 31.12.2015.
 */

@SpringView(name = InboxView.NAME)
public class InboxView extends Panel implements View, Serializable {
    public final static String NAME = "inbox";

    private final static String FROM_PROPERTY = "from";
    private final static String SUBJECT_PROPERTY = "subject";
    private final static String DATE_PROPERTY = "sentDate";
    private final static String[] COLUMNS = {FROM_PROPERTY, SUBJECT_PROPERTY, DATE_PROPERTY};
    private final static String[] HEADERS = {"Od", "Temat", "Data"};

    private final TabSheet tabSheet = new TabSheet();

    {
        tabSheet.setSizeFull();
        tabSheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
    }

    private final Button receiveButton = new Button("Receive post");

    {
        getReceiveButton().addStyleName(ValoTheme.BUTTON_PRIMARY);
        getReceiveButton().addStyleName(ValoTheme.BUTTON_SMALL);
    }

    private final MailTextarea mailTextarea = new MailTextarea();

    {
        mailTextarea.setSizeUndefined();
    }

    @Autowired
    private ViewManager viewManager;

    @Autowired
    private TableDataSetSupplier gridDataSetSupplier;

    @PostConstruct
    public void init() {
        viewManager.configure(this);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    public InboxView() {
        buildLayout();
    }

    private void buildLayout() {
        final VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
        verticalSplitPanel.setSizeFull();
        verticalSplitPanel.setSplitPosition(40, Unit.PERCENTAGE);
        verticalSplitPanel.setFirstComponent(tabSheet);
        verticalSplitPanel.setSecondComponent(mailTextarea);
        setSizeFull();
        setContent(verticalSplitPanel);
    }

    public Button getReceiveButton() {
        return receiveButton;
    }

    public TabSheet.Tab loadMailsTab(final List<Email> mails, final String accountName) {
        Assert.notNull(mails);
        Assert.hasText(accountName);
        final MailTable mailTable = new MailTable();
        mailTable.setDataSet(gridDataSetSupplier.getDataSet(mails));
        mailTable.setVisibleColumns(COLUMNS);
        mailTable.setColumnHeaders(HEADERS);
        mailTable.setSortProperty(DATE_PROPERTY, false);
        return tabSheet.addTab(mailTable, accountName);
    }

    public MailTable getMailTable() {
        return (MailTable) tabSheet.getSelectedTab();
    }

    public MailTextarea getMailTextarea() {
        return mailTextarea;
    }
}
