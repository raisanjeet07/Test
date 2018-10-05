package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeChefQ1 {
    public static int m = 3;
    public static int a[] = {4,7,13}; // _ , _, a + a +2a +3a 
    public static int b[] = {1,6,9};
    public static int n = 8;
    // A's Factor = a(i) * ((2+(n-3)(n-2))/2);
    // B's Factor = b(i) * ((n-2)(n-1))/2;
    public static void main(String[] args) {
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	try {
//	    int testCases = Integer.parseInt(br.readLine());
//	    for(int i = 0;i<testCases;i++){
//		
//	    }
//	} catch (NumberFormatException | IOException e) {
//	    e.printStackTrace();
//	}
	System.out.println(solve());
	System.out.println(getResult());
    }
    
    public static void getInput(BufferedReader reader) throws IOException, NumberFormatException{
	int M = Integer.parseInt(reader.readLine());
	int N = Integer.parseInt(reader.readLine());
	
    }
    
    static long solve(){
	int aSum = getArraySum(a);
	int bSum = getArraySum(b);
	long result = 0;
	if(n > 2)
//	    result = (m*aSum*((2+(n-3)*(n-2))/2) + m*bSum*(((n-2)*(n-1))/2))%((long)(Math.pow(10, 9))*7);
	    result = (m*aSum*((2+(n-3)*(n-2))/2) + m*bSum*(((n-2)*(n-1))/2));
	else
	    result = m*bSum;
	return result;
    }
    
    static int getArraySum(int arr[]){
	int sum = 0;
	for(int i : arr)
	    sum+=i;
	return sum;
    }
    
    static int  getResult(){
	int result = 0;
	for(int i : a){
	    for(int k : b){
		int[] fib = new int[n];
		fib[0] = i;
		fib[1] = k;
		for(int j = 2;j<n;j++)
		    fib[j] = fib[j-1] + fib[j-2];
		result += fib[n-1];
	    }
	}
		return result;
    }
    
}
