package com.sikorasoftware.webmail.view;

import com.sikorasoftware.webmail.view.account.AccountView;
import com.sikorasoftware.webmail.view.inbox.InboxView;
import com.sikorasoftware.webmail.view.outbox.OutboxView;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

public enum ViewType {
    INBOX(InboxView.NAME, InboxView.class, FontAwesome.ENVELOPE, true),
    OUTBOX(OutboxView.NAME, OutboxView.class, FontAwesome.ENVELOPE_SQUARE, true),
    ACCOUNT(AccountView.NAME, AccountView.class, FontAwesome.USER, true);

    private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean stateful;

    ViewType(final String viewName,
             final Class<? extends View> viewClass, final Resource icon,
             final boolean stateful) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
    }

    public boolean isStateful() {
        return stateful;
    }

    public String getViewName() {
        return viewName;
    }

    public Class<? extends View> getViewClass() {
        return viewClass;
    }

    public Resource getIcon() {
        return icon;
    }

    public static ViewType getByViewName(final String viewName) {
        ViewType result = null;
        for (ViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }

}
