package com.sikorasoftware.webmail.mvp;

import com.vaadin.navigator.View;

/**
 * Created by robertsikora on 31.12.2015.
 */
public interface Presenter {
    void setView(View view);
    void bind();
}
