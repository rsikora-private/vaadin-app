package com.sikorasoftware.webmail.view.outbox;

import com.sikorasoftware.webmail.mvp.AbstractPresenter;
import com.sikorasoftware.webmail.outbox.OutboxService;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.VaadinComponent;

/**
 * Created by robertsikora on 29.12.2015.
 */

@VaadinComponent
@UIScope
public class OutboxPresenter extends AbstractPresenter<OutboxView> implements Button.ClickListener {

    @Autowired
    private OutboxService outboxService;

    @Override
    public void buttonClick(final Button.ClickEvent event) {

    }

    @Override
    public void bind() {

    }
}
