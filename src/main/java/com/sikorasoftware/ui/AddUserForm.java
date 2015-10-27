package com.sikorasoftware.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by robertsikora on 27.10.15.
 */

//@UIScope
@ViewScope
@SpringView(name = AddUserForm.VIEW_NAME)
public class AddUserForm extends FormLayout implements View {

    public static final String VIEW_NAME = "add-user";

    @Autowired
    private UserController userController;

    private final static Button     SAVE_BTN = new Button("Save");
    private final static TextField  FIRST_NAME_TF = new TextField("First name");
    private final static TextField  LAST_NAME_TF = new TextField("Last name");
    private final static TextField  PHONE_TF = new TextField("Phone");
    private final static TextField  EMAIL_TF = new TextField("Email");
    private final static DateField  BIRTH_DATE_DF = new DateField("Birth date");

    @PostConstruct
    private void init(){
        configureComponents();
        buildLayout();
    }

    private void configureComponents() {
        SAVE_BTN.addClickListener(event -> userController.save(this));
        FIRST_NAME_TF.setRequired(true);
        FIRST_NAME_TF.setRequiredError("!!!");
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
    public void enter(final ViewChangeListener.ViewChangeEvent event) {

    }
}
