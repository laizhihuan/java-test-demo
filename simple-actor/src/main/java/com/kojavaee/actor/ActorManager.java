package com.kojavaee.actor;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/**
 * 负责向 actor 分配线程（进而分配处理器）来处理消息
 * 
 * @author lzh
 */
public interface ActorManager {
    
    Actor createActor(Class<? extends Actor> clazz, String name);
    
    Actor createAndStartActor(Class<? extends Actor> clazz, String name);
    
    Actor createActor(Class<? extends Actor> clazz, String name, Map<String, Object> options);
    
    Actor createAndStartActor(Class<? extends Actor> clazz, String name, Map<String, Object> options);
    
    void start(Actor a);
    
    void detachActor(Actor actor);
    
    int send(Message message, Actor from, Actor[] to);
    
    int send(Message message, Actor from, Collection<Actor> to);
    
    int send(Message message, Actor from, String category);
    
    int broadcast(Message message, Actor from);
    
    Set<String> getCategories();
    
    void initialize();
    
    void initialize(Map<String,Object> options);
    
    void terminateAndWait();
    
    void terminate();
    
    int getActorCount(Class type);
}
