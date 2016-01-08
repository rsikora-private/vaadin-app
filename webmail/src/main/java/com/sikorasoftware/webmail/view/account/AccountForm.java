package com.sikorasoftware.webmail.view.account;

import com.sikorasoftware.webmail.common.component.textfield.LengthVisitator;
import com.sikorasoftware.webmail.common.component.textfield.NullRepresentationVisitator;
import com.sikorasoftware.webmail.common.component.textfield.TextFieldVisitatorEngine;
import com.sikorasoftware.webmail.common.component.textfield.ValidationVisibleVisitator;
import com.vaadin.ui.*;

/**
 * Created by robertsikora on 06.01.2016.
 */
public class AccountForm extends FormLayout {

    private final static int FIELD_LENGTH = 20;

    private final TextField     name = new TextField("Account name :");
    {
        name.focus();
    }
    private final TextField     email = new TextField("Email :");
    private final PasswordField password = new PasswordField("Password :");
    private final TextField     imapHost = new TextField("IMAP host :");
    private final TextField     imapPort = new TextField("IMAP port :");
    private final CheckBox      imapSSL = new CheckBox("IMAP use SSL");

    public AccountForm(){
        TextFieldVisitatorEngine.visit(this,
                new NullRepresentationVisitator(),
                new ValidationVisibleVisitator(false),
                new LengthVisitator(FIELD_LENGTH));

        setSizeFull();
        setSpacing(true);
        setMargin(true);

        addComponents(name, email, password, imapHost, imapPort, imapSSL);
    }
}
