package com.sikorasoftware.example1.ui.add_user;

import com.sikorasoftware.example1.bundle.I18N;
import com.sikorasoftware.example1.model.User;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import mvp.framework.MVPView;

/**
 * Created by robertsikora on 27.10.15.
 */

@MVPView(presenter = AddUserPresenter.class)
@SpringView(name = AddUserViewImpl.VIEW_NAME)
public class AddUserViewImpl extends FormLayout implements AddUserView {

    public static final String VIEW_NAME = "add-user";

    private final TextField firstName = new TextField(I18N.resolveMessage(FIRST_NAME_LBL));
    private final TextField lastName = new TextField(I18N.resolveMessage(LAST_NAME_LBL));
    private final TextField phone = new TextField(I18N.resolveMessage(PHONE_LBL));
    private final TextField email = new TextField(I18N.resolveMessage(EMAIL_LBL));
    private final DateField birthDate = new DateField(I18N.resolveMessage(DOB_LBL));
    private final Button    saveBtn = new Button(I18N.resolveMessage(SAVE_BTN));

    private User entity = new User();
    private BeanFieldGroup<User> binder = BeanFieldGroup.bindFieldsBuffered(entity, this);

    private void configureComponents() {
        firstName.setRequired(true);
        lastName.setRequired(true);
    }

    private void buildLayout() {
        setSizeUndefined();
        setMargin(true);
        HorizontalLayout actions = new HorizontalLayout(saveBtn);
        actions.setSpacing(true);

        addComponents(actions, firstName, lastName, phone, email, birthDate);
    }

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent event) {
        configureComponents();
        buildLayout();
    }

    @Override
    public User getEntity() {
        return entity;
    }

    @Override
    public BeanFieldGroup<User> getEntityBinder() {
        return binder;
    }

    @Override
    public Button getSaveButton() {
        return saveBtn;
    }
}
