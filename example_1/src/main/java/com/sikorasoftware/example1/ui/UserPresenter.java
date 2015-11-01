package com.sikorasoftware.example1.ui;

import com.sikorasoftware.example1.service.UserService;
import mvp.framework.MVPPresenter;
import mvp.framework.PresenterImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by robertsikora on 27.10.15.
 */

@MVPPresenter
public class UserPresenter extends PresenterImpl<AddUserView> {

    @Autowired
    private UserService userService;

    public void save(){
        System.out.println(this.toString());
        //userService.save(null);
        view().showMessageOnSuccess("Hurra", "Save successed");
    }

    @Override
    public void init(){
        view().registerSaveButtonListener(event -> save());
    }
}
