package com.sikorasoftware.webmail.inbox;

import com.sikorasoftware.webmail.common.listener.WebmailListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by robertsikora on 29.04.2016.
 */

@Component
public class SaveEmailListener implements WebmailListener<InboxListenerContext>{

    @Autowired
    private InboxService inboxService;

    @Override
    public void listen(final InboxListenerContext context) {
        inboxService.saveMessageForDefaultAccount(context.target());
    }

    public void setInboxService(final InboxService inboxService) {
        this.inboxService = inboxService;
    }
}
