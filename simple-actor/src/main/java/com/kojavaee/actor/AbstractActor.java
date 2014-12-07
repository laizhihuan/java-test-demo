package com.kojavaee.actor;

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
    
    protected DefaultMessage getMatch(String subject, boolean isRegExpr) {
        
    }
    
    protected Message testMessage() {
        return getMatch(null,false);
    }
    
    public boolean receive() {
        Message m = testMessage();
        boolean result = m != null;
    }
    
}
