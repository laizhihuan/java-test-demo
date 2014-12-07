package com.kojavaee.actor;

import java.util.Date;

public class DefaultMessage implements Message {
    
    protected long delayUntil = -1; // works like Long.MIN_VALUE;
    
    public long getDelayUntil() {
        return delayUntil;
    }
    
    public void setDelayUntil(long delayUntil) {
        long now = new Date().getTime();
        if(delayUntil <= now) {
            throw new IllegalArgumentException("value should be in the future: " + delayUntil + " vs. " + now);
        }
        this.delayUntil = delayUntil;
    }
    
    protected Actor source;
    
    public Actor getSource() {
        return source;
    }
    
    protected void setSource(Actor source) {
        this.source = source;
    }
    
    protected String subject;
    
    protected void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getSubject() {
        return subject;
    }
    
    protected Object data;

    public Object getData() {
        return data;
    }
    
    protected void setData(Object data) {
        this.data = data;
    }
    
    public DefaultMessage(String subject, Object data) {
        this(subject);
        this.data = data;
    }
    
    public DefaultMessage(String subject) {
        this();
        this.subject = subject;
    }
    
    protected DefaultMessage() {
    }
    
    public Message assignSender(Actor sender) {
        DefaultMessage res = new DefaultMessage(subject, data);
        res.source = sender;
        return res;
    }

}
