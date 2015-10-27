package com.sikorasoftware.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by robertsikora on 27.10.15.
 */
@SpringView(name = DefaultView2.VIEW_NAME)
public class DefaultView2 extends VerticalLayout implements View {

    public static final String VIEW_NAME = "view2";

    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("This is a DEFAULT VIEW 2"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
