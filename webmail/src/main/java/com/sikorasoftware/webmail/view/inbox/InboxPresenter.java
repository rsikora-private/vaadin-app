package com.sikorasoftware.webmail.view.inbox;

import com.sikorasoftware.webmail.inbox.InboxService;
import com.sikorasoftware.webmail.mvp.AbstractPresenter;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.VaadinComponent;

import java.io.Serializable;

/**
 * Created by robertsikora on 06.01.2016.
 */

@VaadinComponent
@UIScope
public class InboxPresenter extends AbstractPresenter<InboxView> implements Serializable {

    @Autowired
    private InboxService inboxService;

    @Override
    protected void bind() {
        view.getReceiveButton().addClickListener(receiveMessages());
    }

    private Button.ClickListener receiveMessages(){
        return event -> {
            Notification.show("starting ...");


            Notification.show("ending ...");
        };
    }

}
