package com.sikorasoftware.webmail.inbox;

import com.sikorasoftware.webmail.common.listener.ListenerContext;

/**
 * Created by robertsikora on 29.04.2016.
 */
public class InboxListenerContext implements ListenerContext<Email> {

    private final Email email;

    public InboxListenerContext(final Email email){
        this.email = email;
    }

    @Override
    public Email target() {
        return null;
    }
}
