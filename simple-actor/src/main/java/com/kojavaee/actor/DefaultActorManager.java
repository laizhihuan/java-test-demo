package com.kojavaee.actor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

public class DefaultActorManager implements ActorManager {
    
    public static final int DEFAULT_ACTOR_THREAD_COUNT = 0;
    /**
     * Configuration key for thread count.
     */
    public static final String ACTOR_THREAD_COUNT = "threadCount";
    
    protected Map<String,AbstractActor> actors = new LinkedHashMap<String,AbstractActor>();
    
    protected Map<String,AbstractActor> runnables = new LinkedHashMap<String,AbstractActor>();
    
    protected Map<String,AbstractActor> waiters = new LinkedHashMap<String,AbstractActor>();
    
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
    /**
     * Test if map is null or empty
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.size() == 0;
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
    
    /**
     * detach an actor
     */
    public void detachActor(Actor actor) {
        if(((AbstractActor)actor).getManager() != this) {
            throw new IllegalStateException("actor not owned by this manager");
        }
        
        String name = actor.getName();
        synchronized (actors) {
            if(actors.containsKey(name)) {
                ((AbstractActor)actor).setManager(null);
                actors.remove(name);
                runnables.remove(name);
                waiters.remove(name);
            } else {
                actor = null;
            }
        }
        if(actor != null) {
            actor.deactivate();
        }
    }
    
    public void detachAllActors() {
        Set<String> xkeys = new HashSet<String>();
        xkeys.addAll(actors.keySet());
        Iterator<String> i = xkeys.iterator();
        while(i.hasNext()) {
            detachActor(actors.get(i.next()));
        }
        synchronized (actors) {
            actors.clear();
            runnables.clear();
            waiters.clear();
        }
    }
    
    protected Random rand = new Random();
    
    /**
     * Create a list of actors in a pseudo-random order;
     */
    public void randomizeActors() {
        synchronized (actors) {
            AbstractActor[] xactors = getActors();
            List<AbstractActor> zactors = new ArrayList<AbstractActor>(xactors.length);
            for(AbstractActor a : xactors) {
                zactors.add(rand.nextInt(zactors.size() + 1),a);
            }
            actors.clear();
            for(AbstractActor a : zactors) {
                actors.put(a.getName(), a);
            }
        }
    }
    
    private AbstractActor[] getActors() {
        // TODO Auto-generated method stub
        return null;
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
        int res = 0;
        if( type != null) {
            synchronized (actors) {
                for(String key : actors.keySet()) {
                    Actor a = actors.get(key);
                    if(type.isAssignableFrom(a.getClass())) {
                        res ++;
                    }
                }
            }
        } else {
            synchronized (actors) {
                res = actors.size();
                
            }
        }
        return res;
    }

    public void awaitMessage(AbstractActor abstractActor) {
        // TODO Auto-generated method stub
        
    }

}
