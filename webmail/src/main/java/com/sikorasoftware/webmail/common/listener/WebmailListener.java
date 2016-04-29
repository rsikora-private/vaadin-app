package com.sikorasoftware.webmail.common.listener;

/**
 * Created by robertsikora on 29.04.2016.
 */
public interface WebmailListener<Ctx extends ListenerContext> {

    void listen(Ctx context);
}
