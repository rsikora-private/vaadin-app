package com.sikorasoftware.webmail.view.inbox;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;

/**
 * Created by robertsikora on 31.12.2015.
 */

@SpringView(name = InboxView.NAME)

public class InboxView extends Panel implements View {

    public final static String NAME = "inbox";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("inbox");
    }
}
