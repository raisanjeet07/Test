package com.san.ques;

public class AnagramCheckMinChange {

    public static int solve(String s1, String s2){
	if(s1.length() != s2.length())
	    return -1;
	int n = s1.length();
	int[] arr = new int[n];
	int c = 0;
	for(int i=0;i<n;i++){
	    c = s1.charAt(i);
	    arr[c-97]++;
	    }
	
	for(int i=0;i<n;i++){
	    c = s2.charAt(i);
	    arr[c-97]--;
	    }
	int sum = 0;
	for(int i =0; i< n ; i++){
	    sum+= arr[i] > 0 ? arr[i] : -arr[i];
	}
	return sum/2;
    }
    
    public static void main(String[] args) {
	System.out.println(solve("abc", "bcb"));
    }
}
