package com;

public class KthSmallestElementInAnUnSortedArray {
    static int[] arr = { 4, 3, 7, 5, 9, 2, 1,-1,1, 6, 8, 0 };
    static int n = arr.length;

    public static void main(String[] args) {
	int k = 5;
	printAllSubArray(arr, n, 15);
    }

    private static void swap(int[] arr2, int i, int k) {
	int tmp = arr[i];
	arr[i] = arr[k];
	arr[k] = tmp;
    }

    public static void printAllSubArray(int[] arr, int n, int sum) {
	int startIndex = 0;
	int tmpSum = 0;
	for (int i = 0; i < n && startIndex < n;) {
	    if (tmpSum + arr[i] == sum){
		printSubArray(arr, startIndex, i);
		tmpSum -= arr[startIndex];
		tmpSum += arr[i];
		startIndex++;
		i++;
		continue;
	    }
	    if (tmpSum + arr[i] <= sum) {
		tmpSum += arr[i];
		i++;
	    } else {
		tmpSum -= arr[startIndex];
		startIndex++;
	    }
	}
    }

    private static void printSubArray(int[] arr2, int startIndex, int i) {
	// TODO Auto-generated method stub
	for (; startIndex <= i; startIndex++)
	    System.out.print(arr[startIndex] + ",");
	System.out.println();

    }
   
    
}
