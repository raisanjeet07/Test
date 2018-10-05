package com;

public class MaxPlan {
public static void main(String[] args) {
    String str = "abacd";
    int[][] arr = new int[str.length()][str.length()];
    int l = str.length();
    for(int i = 0; i< l ;i++){
	arr[i][i] = 1;
    }
    
    for(int i = 0;i<l-1; i++){
	if(str.charAt(i)==str.charAt(i+1))
	    arr[i][i+1] = arr[i+1][i]= 2;
	else
	    arr[i][i+1] = arr[i+1][i]= 1;
    }
    
    for (int i = 2;i<l;i++){
	for(int j=0;j<l-i;j++){
	    if(str.charAt(j)==str.charAt(j+i)){
		arr[j][j+i] = 2+arr[j+1][j+i-1];
	    }else
		arr[j][j+i] = arr[j+1][j+i-1];
	    arr[j+i][j] = arr[j][j+i];
	}
    }
    
    
    
    
    
    print(arr, l);
    
}

public static void print(int[][] arr, int n){
    for (int i = 0;i<n;i++){
	for (int j = 0;j<n;j++){
		System.out.print(arr[i][j]);
	    }
	System.out.println();
    }
}
}
