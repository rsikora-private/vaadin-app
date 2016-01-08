package com.sikorasoftware.webmail.common.component.textarea;


import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

/**
 * Created by robertsikora on 08.01.2016.
 */
public class MailTextarea extends Label {

    public MailTextarea(){

        setImmediate(true);
    }

    public void setContent(final String text){

        super.setValue(text);
        setContentMode(ContentMode.HTML);
    }
}
