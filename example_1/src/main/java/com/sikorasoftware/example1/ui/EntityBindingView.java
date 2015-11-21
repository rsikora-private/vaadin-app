package com.sikorasoftware.example1.ui;

import com.sikorasoftware.example1.model.User;
import com.vaadin.data.fieldgroup.BeanFieldGroup;

/**
 * Created by robertsikora on 09.11.2015.
 */
public interface EntityBindingView <T> {

    T getEntity();

    BeanFieldGroup<T> getEntityBinder();
}
