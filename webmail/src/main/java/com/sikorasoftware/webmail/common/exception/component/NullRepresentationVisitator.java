package com.sikorasoftware.webmail.common.exception.component;

import com.vaadin.ui.AbstractTextField;

/**
 * Created by robertsikora on 06.01.2016.
 */

public class NullRepresentationVisitator implements TextFieldVisitator {

    @Override
    public AbstractTextField decorate(final AbstractTextField abstractTextField) {
        abstractTextField.setNullRepresentation("");
        return abstractTextField;
    }
}
