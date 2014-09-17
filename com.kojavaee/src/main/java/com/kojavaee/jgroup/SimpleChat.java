package com.kojavaee.jgroup;

import org.jgroups.JChannel;

/**
 * http://www.oschina.net/translate/jgroups-writing-a-simple-application
 * @author zhihuanglai
 *
 */
public class SimpleChat {
	
	JChannel channel;
	String user_name = System.getProperty("user.name","n/a");
	
	private void start() throws Exception {
		channel = new JChannel(); //use the default config, udp.xml
		channel.connect("ChatCluster");
	}
	
	public static void main(String[] args) throws Exception {
		new SimpleChat().start();
	}
}
