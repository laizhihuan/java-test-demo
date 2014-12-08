package com.kojavaee.actor;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + "source=" + source + ", subject=" + subject + ", data=" + Utils.truncate(data) + ", delay=" + delayUntil + "]";
    }
    
    public boolean subjectMatches(String s) {
        return subject != null ? subject.equals(s) : false;
    }
    
    /**
     * test if this message subject matches a reg expr.
     * @param p
     * @return
     */
    public boolean subjectMatches(Pattern p) {
        boolean result = false;
        if(p != null && subject != null) {
            Matcher m = p.matcher(subject);
            result = m.matches();
        }
        return result;
    }
    
    protected List<MessageListener> listeners = new LinkedList<MessageListener>();
    
    public void addMessageListener(MessageListener l) {
        if(listeners.contains(l)) {
            listeners.add(l);
        }
    }
    
    public void removeMessageListener(MessageListener l) {
        listeners.remove(l);
    }
    
    public void fireMessageListener(MessageEvent e) {
        for(MessageListener l : listeners) {
            l.onMessage(e);
        }
    }
    

}
