package com.sikorasoftware.webmail.inbox.jbpm;

import com.sikorasoftware.webmail.common.listener.WebmailListener;
import com.sikorasoftware.webmail.inbox.InboxListenerContext;
import org.springframework.stereotype.Component;

/**
 * Created by robertsikora on 29.04.2016.
 */

@Component
public class JBPMListener implements WebmailListener<InboxListenerContext>{

    @Override
    public void listen(final InboxListenerContext context) {
        System.out.println("JBPM");
    }
}
