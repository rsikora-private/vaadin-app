package com.sikorasoftware.webmail.view.outbox;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.FormLayout;

import java.io.Serializable;

/**
 * Created by robertsikora on 07.01.2016.
 */

@SpringView(name = OutboxView.NAME)
public class OutboxView extends FormLayout implements View, Serializable {

    public final static String NAME = "outbox";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
