package com.kojavaee.shell;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * 远程执行shell脚本类
 * 
 * mytest.sh
 * echo $1 $2 $#
 * #print $1
 * 
 * @author zhihuanglai
 *
 */
public class RmtShellExecutor {
	
	private Connection connection;
	private String ip;
	private String username;
	private String password;
	private String CHARSET = "UTF-8";
	
	private static final int TIME_OUT = 1000 * 5 * 60;

	public RmtShellExecutor(String ip, String username,String password) {
		this.ip = ip;
		this.username = username;
		this.password = password;
	}
	
	private boolean login() throws IOException {
		connection = new Connection(this.ip);
		connection.connect();
		return connection.authenticateWithPassword(this.username, this.password);
	}
	
	public int exec(String cmd)  throws Exception {
		InputStream stdOut = null; 
        InputStream stdErr = null; 
        String outStr = ""; 
        String outErr = ""; 
        int ret = -1; 
        try { 
            if (login()) { 
                // Open a new {@link Session} on this connection 
                Session session = connection.openSession(); 
                // Execute a command on the remote machine. 
                session.execCommand(cmd); 
                
                stdOut = new StreamGobbler(session.getStdout()); 
                outStr = processStream(stdOut, CHARSET); 
                
                stdErr = new StreamGobbler(session.getStderr()); 
                outErr = processStream(stdErr, CHARSET); 
                
                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT); 
                
                System.out.println("outStr=" + outStr); 
                System.out.println("outErr=" + outErr); 
                
                ret = session.getExitStatus(); 
            } else { 
                throw new ShellException("登录远程机器失败" + ip); 
            } 
        } finally { 
            if (connection != null) { 
            	connection.close(); 
            	connection = null;
            } 
            if(stdOut != null) {
            	stdOut.close();
            	stdOut = null;
            }
            if(stdErr != null) {
            	stdErr.close();
            	stdErr = null;
            }
        } 
        return ret; 
	}

	private String processStream(InputStream in, String charset) throws UnsupportedEncodingException, IOException {
		byte[] buf = new byte[1024];
		StringBuffer sb = new StringBuffer();
		while(in.read(buf) != -1) {
			sb.append(new String(buf,charset));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		RmtShellExecutor exe = new RmtShellExecutor("000.000.000.000", "username", "password");
		try {
			System.out.println(exe.exec("sh /home/../mytest.sh kok kooo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
