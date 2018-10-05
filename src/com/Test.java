package com;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Test {
    public static Double formatUpto2Decimal(Double doubleAmount){
	DecimalFormat decimalFormater = new DecimalFormat(".##");
	return Double.parseDouble(decimalFormater.format(doubleAmount));
    }
public static void main(String[] args) {
    int n = 6;
    int m = 6;
    int[][] arr = {{1,1,1,1,1,1},{0,0,1,1,1,1},{0,0,0,0,0,1},{0,0,1,1,1,1},{0,0,1,1,1,1},{0,0,0,0,0,0}};
   // System.out.println(getmaxZeroInMatrix(arr, n, m));
    int[] ar = {1,2,3,4};
    System.out.println(formatUpto2Decimal(0.0000000023124));
    
}
public static void main(int[] args) {
    int[] ar = {2,3,5,6};
    System.out.println(Arrays.binarySearch(ar, 4));
}

@Override
protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return null;
}
void show(int[] arr){}
void show(String arr){}
static int getmaxZeroInMatrix(int[][] arr, int n, int m){
    int startIndex = -1;
    for(int i = 0;i<n;i++){
	int k = 0;
	for(k = startIndex+1; k<m; k++){
	    if(arr[i][k] == 0)
		startIndex++;
	    else
		break;
	}
	if(k == m)
	    break;
    }
    
    return startIndex+1;
}


}
