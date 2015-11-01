package com.sikorasoftware.example1.ui;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import mvp.framework.MVPView;

import javax.annotation.PostConstruct;

/**
 * Created by robertsikora on 27.10.15.
 */

@MVPView(presenter = UserPresenter.class)
@SpringView(name = AddUserViewImpl.VIEW_NAME)
public class AddUserViewImpl extends FormLayout implements AddUserView {

    public static final String VIEW_NAME = "add-user";

    private final Button SAVE_BTN = new Button("Save");
    private final TextField FIRST_NAME_TF = new TextField("First name");
    private final TextField LAST_NAME_TF = new TextField("Last name");
    private final TextField PHONE_TF = new TextField("Phone");
    private final TextField EMAIL_TF = new TextField("Email");
    private final DateField BIRTH_DATE_DF = new DateField("Birth date");

    private void configureComponents() {
        FIRST_NAME_TF.setRequired(true);
        FIRST_NAME_TF.setRequiredError("!!!");
        FIRST_NAME_TF.focus();
        LAST_NAME_TF.setRequired(true);
    }

    private void buildLayout() {
        setSizeUndefined();
        setMargin(true);
        HorizontalLayout actions = new HorizontalLayout(SAVE_BTN);
        actions.setSpacing(true);
        addComponents(actions, FIRST_NAME_TF, LAST_NAME_TF, PHONE_TF, EMAIL_TF, BIRTH_DATE_DF);
    }

    @Override
    public void registerSaveButtonListener(Button.ClickListener listener) {
        SAVE_BTN.addClickListener(listener);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    @PostConstruct
    public void init() {
        configureComponents();
        buildLayout();
    }
}
