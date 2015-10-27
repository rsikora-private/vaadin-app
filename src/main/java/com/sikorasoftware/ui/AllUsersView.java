package com.sikorasoftware.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by robertsikora on 27.10.15.
 */
@SpringView(name = AllUsersView.VIEW_NAME)
public class AllUsersView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "all-users";

    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
