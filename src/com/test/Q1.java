package com.test;

import java.util.Arrays;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
	int[] arr = {1,2,3};
	int[] dic = {2,5};
	String[] arrS = {"a","b","c","d","e"};
	String[] dicS = {"a","b","c","d","e"};
	
	System.out.println(solve(arr, dic));
    }

    static int solve(int[] arr, int[] dic){
	int[][] table = new int[arr.length+1][arr.length+1];
	int count = 0;
	int n = arr.length;
	List list = Arrays.asList(dic);
	for(int col = 1; col <= n; col++){
	    if(list.contains(arr[col-1]))
		count++;
	    table[0][col] = arr[col-1];
	}
	for(int row = 1; row <= n; row++){
	    for(int col=row+1 ;col <= n ; col++){
		int tmp = table[row-1][col] ^ arr[row-1];
		if(list.contains(tmp))
		    count++;
		table[row][col] = tmp;
	    }
	}
	print(table);
	return count;
    }
    
    static void solve(String[] arr, String[] dic){
	String[][] table = new String[arr.length+1][arr.length+1];
	int n = arr.length;
	List list = Arrays.asList(dic);
	for(int col = 1; col <= n; col++){
	    if(list.contains(arr[col-1]))
		    System.out.println(arr[col-1]);
	    table[0][col] = arr[col-1];
	}
	for(int row = 1; row <=n; row++){
	    for(int col=row+1 ;col <=n ; col++){
		String tmp = table[row-1][col] + arr[row-1];
		if(list.contains(tmp))
		    System.out.println(tmp);
		table[row][col] = tmp;
	    }
	}
	print(table);
    }
    
    public static int getXOR(int a, int b){
	return a^b;
    }
    public static void print(Object[][] arr) {

	for (Object[] a : arr) {
	    for (Object i : a) {
		System.out.print(i + "\t");
	    }
	    System.out.println();
	}
    }
    
    public static void print(int[][] arr) {

	for (int[] a : arr) {
	    for (int i : a) {
		System.out.print(i + ",");
	    }
	    System.out.println();
	}
    }
}
