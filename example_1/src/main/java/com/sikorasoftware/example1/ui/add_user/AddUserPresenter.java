package com.sikorasoftware.example1.ui.add_user;

import com.sikorasoftware.example1.bundle.I18N;
import com.sikorasoftware.example1.service.UserService;
import com.sikorasoftware.example1.ui.add_user.AddUserView;
import com.vaadin.data.fieldgroup.FieldGroup;
import mvp.framework.MVPPresenter;
import mvp.framework.PresenterImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by robertsikora on 27.10.15.
 */

@MVPPresenter
public class AddUserPresenter extends PresenterImpl<AddUserView> {

    @Autowired
    private UserService userService;

    public void save() {

        try {
            view().getEntityBinder().commit();
        } catch (FieldGroup.CommitException e) {
            view().showMessageOnError("", I18N.resolveMessage("VALIDATION.ERROR"));
            return;
        }
        userService.save(view().getEntity());

        view().showMessageOnSuccess("", I18N.resolveMessage("SAVE.SUCCESS"));
    }

    @Override
    public void init(){
        view().getSaveButton().addClickListener(t->save());
    }
}
