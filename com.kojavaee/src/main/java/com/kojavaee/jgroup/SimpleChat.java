package com.kojavaee.jgroup;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

/**
 * http://www.oschina.net/translate/jgroups-writing-a-simple-application
 * @author zhihuanglai
 *
 */
public class SimpleChat extends ReceiverAdapter {
	
	JChannel channel;
	String user_name = System.getProperty("user.name","n/a");
	final List<String> state=new LinkedList<String>();
	public static String classpath = SimpleChat.class.getClassLoader().getResource("").getPath().replaceAll("%20", " ");
	
	private void start() throws Exception {
		channel = new JChannel(classpath+"/jgroups/udp.xml"); //use the default config, udp.xml
		channel.setReceiver(this);
		channel.connect("ChatCluster");
		channel.getState(null, 10000);  //getState() 方法第一个参数是目标成员，null 表示首个成员（协调者）。第二个参数是超时时间，这里我们设置了 10 秒钟的超时时间，意味着状态传输的时间必须在 10 秒内完成，否则将会抛出异常，0 代表没有超时时间。
		eventLoop();
		channel.close();
	}
	
	public void viewAccepted(View new_view) {
	    System.out.println("** view: " + new_view);
	}
	 
	public void receive(Message msg) {
	    String line = msg.getSrc() + ": " + msg.getObject();
		System.out.println(line);
		synchronized (state) {
			state.add(line);
		}
	}
	@SuppressWarnings("unchecked")
	public void setState(InputStream input) throws Exception {
		 
	    List<String> list;
	    list=(List<String>)Util.objectFromStream(new DataInputStream(input));
	 
	    synchronized(state) {
	        state.clear();
	        state.addAll(list);
	 
	    }
	 
	    System.out.println(list.size() + " messages in chat history):");
	 
	    for(String str: list) {
	        System.out.println(str);
	    }
	 
	}
	
	public void getState(OutputStream output) throws Exception {
	    synchronized(state) {
	        Util.objectToStream(state, new DataOutputStream(output));
	    }
	}
	
	private void eventLoop() {
		 
	    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	 
	    while(true) {
	        try {
	            System.out.print("> "); System.out.flush();
	            String line=in.readLine().toLowerCase();
	            if(line.startsWith("quit") || line.startsWith("exit"))
	                break;
	 
	            line="[" + user_name + "] " + line;
	            Message msg=new Message(null, null, line);
	            channel.send(msg);
	        }
	 
	        catch(Exception e) {
	        }
	    }
	}
	
	public static void main(String[] args) throws Exception {
		new SimpleChat().start();
	}
}
