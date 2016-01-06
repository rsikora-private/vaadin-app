package com.sikorasoftware.webmail.common.exception.component;

import com.vaadin.ui.AbstractTextField;

/**
 * Created by robertsikora on 06.01.2016.
 */
public class LengthVisitator implements TextFieldVisitator {

    private final int length;

    public LengthVisitator(final int length){
        this.length = length;
    }

    @Override
    public AbstractTextField decorate(final AbstractTextField abstractTextField) {
        abstractTextField.setColumns(length);
        return abstractTextField;
    }
}
