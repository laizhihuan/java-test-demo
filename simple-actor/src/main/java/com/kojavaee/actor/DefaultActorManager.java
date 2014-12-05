package com.kojavaee.actor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class DefaultActorManager implements ActorManager {
    
    public static final int DEFAULT_ACTOR_THREAD_COUNT = 0;
    
    protected static DefaultActorManager instance;
    
    public static DefaultActorManager getDefaultInstance() {
        
        if (instance == null) {
            synchronized (instance) {
                if(instance == null) {
                    instance = new DefaultActorManager();
                    Map<String, Object> options = null;
                    Properties p = new Properties();
                    try {
                        p.load(new FileInputStream("ActorManager.properties"));
                    } catch (IOException e) {
                        try {
                            p.load(new FileInputStream("/resource/ActorManager.properties"));
                        } catch (IOException e1) {
                            System.out.println("DefaultActorManager: no configutration: " + e);
                        }
                    }
                    if (!isEmpty(p)) {
                        options = new HashMap<String, Object>();
                        for (Object key : p.keySet()) {
                            String skey = (String) key;
                            options.put(skey, p.getProperty(skey));
                        }
                    }
                    instance.initialize(options);
                }
            }
        }
        return instance;
    }

    private static boolean isEmpty(Properties p) {
        // TODO Auto-generated method stub
        return false;
    }

    public Actor createActor(Class<? extends Actor> clazz, String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public Actor createAndStartActor(Class<? extends Actor> clazz, String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public Actor createActor(Class<? extends Actor> clazz, String name, Map<String, Object> options) {
        // TODO Auto-generated method stub
        return null;
    }

    public Actor createAndStartActor(Class<? extends Actor> clazz, String name,
            Map<String, Object> options) {
        // TODO Auto-generated method stub
        return null;
    }

    public void start(Actor a) {
        // TODO Auto-generated method stub
        
    }

    public void detachActor(Actor actor) {
        // TODO Auto-generated method stub
        
    }

    public int send(Message message, Actor from, Actor[] to) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int send(Message message, Actor from, Collection<Actor> to) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int send(Message message, Actor from, String category) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int broadcast(Message message, Actor from) {
        // TODO Auto-generated method stub
        return 0;
    }

    public Set<String> getCategories() {
        // TODO Auto-generated method stub
        return null;
    }

    public void initialize() {
        // TODO Auto-generated method stub
        
    }

    public void initialize(Map<String, Object> options) {
        // TODO Auto-generated method stub
        
    }

    public void terminateAndWait() {
        // TODO Auto-generated method stub
        
    }

    public void terminate() {
        // TODO Auto-generated method stub
        
    }

    public int getActorCount(Class type) {
        // TODO Auto-generated method stub
        return 0;
    }

}
