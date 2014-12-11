package com.kojavaee.actor;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractActor implements Actor {
    public static final int DEFAULT_MAX_MESSAGES = 100;
    protected DefaultActorManager manager;
    
    public ActorManager getManager() {
        return manager;
    }
    
    public void setManager(DefaultActorManager manager) {
        if(this.manager != null && manager != null) {
            throw new IllegalStateException("cannot change manager of attached actor");
        }
        this.manager = manager;
    }
    
    protected String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if(manager != null) {
            throw new IllegalStateException("cannot change name if manager set");
        }
        this.name = name;
    }
    
    protected String category = DEFAULT_CATEGORY;
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    protected List<DefaultMessage> messages = new LinkedList<DefaultMessage>();
    
    protected DefaultMessage getMatch(String subject, boolean isRegExpr) {
        DefaultMessage res = null;
        synchronized(messages) {
            res = (DefaultMessage)peekNext(subject, isRegExpr);
        }
        return res;
    }
    
    protected Message testMessage() {
        return getMatch(null,false);
    }
    
    /**
     * Process a message conditionally. If testMessage() returns null no message
     * will be consumed.
     * 
     * @see AbstractActor#testMessage()
     */
    public boolean receive() {
        Message m = testMessage();
        boolean result = m != null;
        if(result) {
            boolean f = remove(m);
            if(!f) {
                System.out.println(String.format("receive message not removed: %s", m));
            }
            
            DefaultMessage dm = (DefaultMessage)m;
            try {
                dm.fireMessageListener(new MessageEvent(this, dm, MessageEvent.MessageStatus.DELIVERED));
                loopBody(m);
                dm.fireMessageListener(new MessageEvent(this, dm, MessageEvent.MessageStatus.COMPLETED));
            } catch(Exception e) {
                dm.fireMessageListener(new MessageEvent(this, dm, MessageEvent.MessageStatus.FAILED));
                System.err.println("loop exception"+e);
            }
        }
        manager.awaitMessage(this);
        return result;
    }
    
    /** Process the accepted subject. */
    abstract protected void loopBody(Message m);

    public DefaultMessage[] getMessages() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean getHasThread() {
        // TODO Auto-generated method stub
        return false;
    }
}
