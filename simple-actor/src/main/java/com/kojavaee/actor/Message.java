package com.kojavaee.actor;

/**
 * Message : Actor 之间发送的消息
 * 
 * @author lzh
 */
public interface Message {
    Actor getSource();
    
    String getSubject();
    
    Object getData();
}
