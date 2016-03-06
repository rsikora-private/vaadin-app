package com.sikorasoftware.webmail.inbox.jbpm;

/**
 * Created by robertsikora on 20.02.2016.
 */
public final class MessageContext {

    private final String sender;
    private final String boxName;

    public MessageContext(String sender, String boxName) {
        this.sender = sender;
        this.boxName = boxName;
    }

    public String getSender() {
        return sender;
    }

    public String getBoxName() {
        return boxName;
    }
}
