package com.kojavaee.zookeeper;

import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperWatcher implements Watcher ,Runnable {
    
    private ZooKeeper zooKeeper = null;
    private String znode;

    public ZooKeeper getZooKeeper() {
        return this.zooKeeper;
    }

    public void connect(String hosts, String znode) throws IOException,
            InterruptedException, KeeperException {
        this.zooKeeper = new ZooKeeper(hosts, 2000, this);
        this.znode = znode;
        this.zooKeeper.exists(znode, true);
    }

    public void setData(byte[] data) {
        try {
            Stat s = this.zooKeeper.exists(znode, false);
            this.zooKeeper.setData(znode, data, s.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void process(WatchedEvent event) {
        System.out.println(event.toString());
        try {
            this.zooKeeper.exists(znode, true);//不知道为什么一定要加上这句话，下次事件到来时，才会触发process事件
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        try {
            synchronized (this) {
                           while (true) {
                              wait();
                            }
                        }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
