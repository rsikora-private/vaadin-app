package com.sikorasoftware.webmail.common.exception.component;

import com.vaadin.ui.AbstractTextField;

/**
 * Created by robertsikora on 06.01.2016.
 */
public interface TextFieldVisitator {

    AbstractTextField decorate(AbstractTextField abstractTextField);
}
