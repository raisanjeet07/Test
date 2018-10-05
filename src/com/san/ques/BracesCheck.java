package com.san.ques;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class BracesCheck {
    
    public static boolean solve(String str){
	Map<String,String> braceMap = new HashMap<>();
	braceMap.put("(", "");
	braceMap.put("{", "");
	braceMap.put("[", "");
	braceMap.put(")", "(");
	braceMap.put("}", "{");
	braceMap.put("]", "[");
	if(str == null || str.length() == 0)
	    return true;
	if(!"".equals(braceMap.get(str.charAt(0)+"")))
	    return false;

	int top = -1;
	String[] stack = new String[str.length()];
	stack[++top] = str.charAt(0)+"";
	for(int i = 1; i<str.length();i++){
	    if("".equals(braceMap.get(str.charAt(i)+"")))
		stack[++top] = str.charAt(i)+"";
	    else if(top != -1 && stack[top].equals(braceMap.get(str.charAt(i)+"")))
		top--;
	    else
		return false;
	}
	if(top == -1)
	    return true;
	return false;
    }
    public static void main(String[] args) {
	try {
	    BufferedReader inputreader = new BufferedReader(new FileReader("input.txt"));
	    BufferedReader outputReader = new BufferedReader(new FileReader("output.txt"));
	    String inputString = inputreader.readLine();
	    String outputString = outputReader.readLine().trim();
	    while(inputString != null && outputString != null){
		String tmp = solve(inputString) ? "YES" : "NO";
		if(!outputString.equals(tmp))
		    System.out.println(inputString);
		inputString = inputreader.readLine();
		outputString = outputReader.readLine();
	    }
	    inputreader.close();
	    outputReader.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
    }
}
