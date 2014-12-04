package com.kojavaee.actor;

/**
 * <pre>
 * Actor 是一个执行单元，一次处理一条消息。Actor具有几个特点:
 * <li>每个actor有一个name，改名称在每个ActorManager中必须是唯一对应的</li>
 * <li>每个actor属于一个category；</li>
 * </pre>
 * @author lzh
 */
public interface Actor extends Runnable {
    String DEFAULT_CATEGORY = "default";
    
    String getName();
    
    void setName(String name);
    
    String getCategory();
    
    void setCategory(String category);
    
    boolean receive();
    
    boolean willReceive(String subject);
    
    Message peekNext();
    
    Message peekNext(String subject);
    
    Message peekNext(String subject, boolean isRegExpr);
    
    boolean remove(Message message);
    
    void activate();
    
    void deactivate();
    
    void setSuspended(boolean f);
    
    boolean isSuspended();
    
    void shutdown();
    
    boolean isShutdown();
    
    int getMessageCount();
    
    int getMaxMessageCount();
}
