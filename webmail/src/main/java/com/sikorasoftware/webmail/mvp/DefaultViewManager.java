package com.sikorasoftware.webmail.mvp;

import com.vaadin.navigator.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * Created by robertsikora on 31.12.2015.
 * <p>
 * ViewManager that configure Presenters following
 * the naming convention XXView->XXPresenter
 */

@Component
public class DefaultViewManager implements ViewManager {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void configure(final View view) {
        Assert.notNull(view, "Passed view cannot be null.");
        final AbstractPresenter p = (AbstractPresenter) applicationContext.getBean(getPresenterName(view.getClass()));
        p.setView(view);
        p.bind();

    }

    private String getPresenterName(final Class<?> clazz) {
        return StringUtils.uncapitalize(clazz.getSimpleName()).replace("View", "Presenter");
    }
}
