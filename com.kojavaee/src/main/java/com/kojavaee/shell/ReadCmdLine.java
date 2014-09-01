package com.kojavaee.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCmdLine {
	
	public static void main(String[] args) throws InterruptedException {
		Process process = null;
		List<String> processList = new ArrayList<String>();
		
		try {
			process = Runtime.getRuntime().exec("ps -aux");
			int exitValue = process.waitFor();
			
			if(0 != exitValue) {
				System.out.println("call shell failed . error code is : " + exitValue);
			}
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			while((line = input.readLine()) != null) {
				processList.add(line);
			}
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String line : processList) {
			System.out.println(line);
		}
	}
}
