package com.kojavaee.actor;

/**
 * Listener for message reception
 * 
 * @author lzh
 */
public interface MessageListener {
    /**
     * Call-back for message reception
     * @param e event
     */
    void onMessage(MessageEvent e);
}
