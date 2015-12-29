package com.sikorasoftware.example1.ui.all_users;

import com.sikorasoftware.example1.bundle.I18N;
import com.sikorasoftware.example1.model.User;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import mvp.framework.MVPView;

/**
 * Created by robertsikora on 27.10.15.
 */

@MVPView(presenter = AllUserPresenter.class)
@SpringView(name = AllUsersViewImpl.VIEW_NAME)
public class AllUsersViewImpl extends VerticalLayout implements AllUserView {

    public static final String VIEW_NAME = "all-users";

    private final TextField filter = new TextField();
    {
        filter.setInputPrompt("filter ... ");
    }
    private final Grid userList = new Grid();
    private final Label label = new Label();

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent event) {
        addComponents(filter, userList, label);
        configureComponents();
    }

    private void configureComponents() {
        userList.setSelectionMode(Grid.SelectionMode.SINGLE);
        userList.setColumnOrder("id", "firstName", "lastName", "phone", "email", "birthDate");
        userList.removeColumn("id");
    }


    @Override
    public TextField getFilter() {
        return filter;
    }

    @Override
    public Grid getGrid() {
        return userList;
    }

    @Override
    public Label getLabel() {
        return label;
    }
}
