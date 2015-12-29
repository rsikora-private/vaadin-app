package com.sikorasoftware.example1.ui.all_users;

import com.sikorasoftware.example1.model.User;
import com.sikorasoftware.example1.service.UserService;
import com.vaadin.data.util.BeanItemContainer;
import mvp.framework.MVPPresenter;
import mvp.framework.PresenterImpl;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by robertsikora on 21.11.2015.
 */

@MVPPresenter
public class AllUserPresenter extends PresenterImpl<AllUserView> {

    @Autowired
    private UserService userService;

    @Override
    public void init() {
        fillGrid();
        bindFilter();
        bindLabel();
    }

    private void fillGrid(){
        view().getGrid().setContainerDataSource(new BeanItemContainer<>(User.class, userService.getAllUsers()));
    }

    private void bindFilter(){
        view().getFilter().addTextChangeListener(blur ->
                view().getGrid().setContainerDataSource(
                        new BeanItemContainer<>(User.class, userService.getAllUsers(blur.getText())))
        );
    }

    private void bindLabel(){
        view().getGrid().addSelectionListener(t -> view().getLabel().setValue(t.getSelected().toString()));
    }
}
