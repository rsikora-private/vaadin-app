package com.sikorasoftware.webmail.common.exception.component;

import com.vaadin.ui.AbstractTextField;

/**
 * Created by robertsikora on 06.01.2016.
 */
public class ValidationVisibleVisitator implements TextFieldVisitator {

    private final boolean validationVisible;

    public ValidationVisibleVisitator(final boolean validationVisible){
        this.validationVisible = validationVisible;
    }

    @Override
    public AbstractTextField decorate(final AbstractTextField abstractTextField) {
        abstractTextField.setValidationVisible(validationVisible);
        return abstractTextField;
    }
}
