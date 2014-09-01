package com.kojavaee.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCmdLine {
	
	public static void main(String[] args) {
		Process process = null;
		List<String> processList = new ArrayList<String>();
		
		try {
			process = Runtime.getRuntime().exec("ps -aux");
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
