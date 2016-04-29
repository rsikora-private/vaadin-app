package com.sikorasoftware.webmail.inbox;

import com.sikorasoftware.webmail.common.listener.WebmailListener;

/**
 * Created by robertsikora on 29.04.2016.
 */
public class SaveEmailListener implements WebmailListener<InboxListenerContext>{

    private InboxService inboxService;

    @Override
    public void listen(final InboxListenerContext context) {
        inboxService.saveMessageForDefaultAccount(context.target());
    }

    public void setInboxService(final InboxService inboxService) {
        this.inboxService = inboxService;
    }
}
