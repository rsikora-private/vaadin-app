package com.sikorasoftware.example1.ui;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by robertsikora on 27.10.15.
 */
@SpringView(name = AllUsersViewImpl.VIEW_NAME)
public class AllUsersViewImpl extends VerticalLayout implements AllUserView {

    public static final String VIEW_NAME = "all-users";

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent event) {

    }
}
