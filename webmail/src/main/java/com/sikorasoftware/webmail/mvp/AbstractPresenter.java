package com.sikorasoftware.webmail.mvp;

import com.vaadin.navigator.View;

/**
 * Created by robertsikora on 04.01.2016.
 */
public abstract class AbstractPresenter<V extends View> {

    protected V view;

    public void setView(V view){
        this.view = view;
    }

    protected abstract void bind();
}
