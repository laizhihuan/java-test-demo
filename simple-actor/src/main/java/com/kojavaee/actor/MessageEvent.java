package com.kojavaee.actor;

import java.util.EventObject;

public class MessageEvent extends EventObject {

    public static enum MessageStatus {SENT,DELIVERED,COMPLETED,FAILED};
    
    protected MessageStatus status;
    
    protected Message message;
    
    public MessageStatus getStatus() {
        return status;
    }
    
    public MessageEvent(Object source,Message m, MessageStatus status) {
        super(source);
        this.message = m;
        this.status = status;
    }
    
}
