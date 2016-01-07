package com.sikorasoftware.webmail.view.inbox;

import com.sikorasoftware.webmail.mvp.ViewManager;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * Created by robertsikora on 31.12.2015.
 */

@SpringView(name = InboxView.NAME)
public class InboxView extends FormLayout implements View, Serializable {

    public final static String NAME = "inbox";

    private final Button receiveButton = new Button("Receive post");
    {
        getReceiveButton().addStyleName(ValoTheme.BUTTON_PRIMARY);
        getReceiveButton().addStyleName(ValoTheme.BUTTON_SMALL);
    }

    @Autowired
    private ViewManager viewManager;

    @PostConstruct
    public void init() {
        viewManager.configure(this);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    public InboxView(){
        buildLayout();
    }

    private void buildLayout() {
        final HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponents(getReceiveButton());

        addComponents(horizontalLayout);
    }

    public Button getReceiveButton() {
        return receiveButton;
    }
}
