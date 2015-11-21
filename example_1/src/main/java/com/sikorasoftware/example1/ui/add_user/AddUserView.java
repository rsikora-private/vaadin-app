package com.sikorasoftware.example1.ui.add_user;

import com.sikorasoftware.example1.model.User;
import com.sikorasoftware.example1.ui.EntityBindingView;
import com.vaadin.ui.Button;
import mvp.framework.View;

/**
 * Created by robertsikora on 31.10.15.
 */
public interface AddUserView extends View, EntityBindingView<User> {

    String FIRST_NAME_LBL = "Add-User.firstName";
    String LAST_NAME_LBL = "Add-User.lastName";
    String PHONE_LBL = "Add-User.phoneName";
    String EMAIL_LBL = "Add-User.emailName";
    String DOB_LBL = "Add-User.dob";
    String SAVE_BTN = "Add-User.save";

    void registerSaveButtonListener(Button.ClickListener listener);
}
