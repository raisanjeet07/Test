package com.san.ques;

import java.util.Arrays;

public class NonSequenceMaxSum {
    public static int solve(int arr[]) {
	int table[] = new int[arr.length + 2];
	for (int i = arr.length - 1; i > -1; i--) {
	    table[i] = max(table[i + 1], table[i + 2] + arr[i]);
	}
	return table[0];
    }

    public static int max(int a, int b) {
	return a > b ? a : b;
    }

    public static void main(String[] args) {
	int arr[] = { 7, 6, 8, 23,234,4,54,65,34234,6565 };
	System.out.println(solve2(arr));
    }
    
    public static int solve2(int[] arr){
	int[] table = new int[arr.length];
	table[0] = arr[0];
	table[1] = max(arr[1],arr[0]);
	for( int i = 2; i<arr.length;i++){
	    table[i] = max(table[i-1], table[i-2]+arr[i]);
	    System.out.println(Arrays.toString(table));
	}
	return table[arr.length-1];
    }
}
