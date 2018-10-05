package com;

public class MaxProfit {
static int[] len = {1,2,3,4,5,6,7,8};
static int[] profit = {3,5,8,9,10,17,17,20};
static int l = 8;
static int[][] table = new int[l+1][len.length+1];

public static void main(String[] args) {
    
    
    for(int i = 1;i<=l;i++){
	for(int k = 0;k<len.length;k++){
	    int l = k+1;
	    int currentMesure = len[k];
	    int tmp = i-currentMesure;
	    if(tmp >= 0){
		int p1 = profit[k] + table[tmp][l];
		int p2 = table[i][l-1];
		table[i][l] = p1>p2 ? p1:p2;
	    }else{
		table[i][l] = table[i][l-1];
	    }
	}
    }
    print(table);
}

public static void print(int[][] arr) {
	
    for(int [] a : arr){
	for(int i : a){
	    System.out.print(i+",");
	}
	System.out.println();
    }
}
}
