
package com.kojavaee.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;

public class TestConfigUpdate {
    public static void main(String[] args) throws IOException, InterruptedException,
            KeeperException {
        ZooKeeperWatcher zw1 = new ZooKeeperWatcher();
        zw1.connect("127.0.0.1", "/root1");
        ZooKeeperWatcher zw2 = new ZooKeeperWatcher();
        zw2.connect("127.0.0.1", "/root1");
        new Thread(zw1).start();
        new Thread(zw2).start();
        ConfigerCenter cc = new ConfigerCenter("127.0.0.1", "/root1");
        cc.updateConfig("a");
        cc.updateConfig("b");
        cc.updateConfig("c");
        cc.updateConfig("d");
    }
}
