package com;

public class LongestPalandromInString {
    static String str = "qwerttrewq";
    static int n = str.length();
    static int[] table[] = new int[n][n];
    static {
	for (int i = 0; i < n; i++)
	    table[i][i] = 1;
	for (int i = 1; i < n; i++) {
	    if (str.charAt(i - 1) == str.charAt(i)) {
		table[i - 1][i] = 2;
		table[i][i - 1] = 2;
	    }
	}
    }

    public static void main(String[] args) {
	getLongestPalandrom();
	print(table, n);
    }

    static void getLongestPalandrom() {
	for (int i = 3; i <= n; i++) {
	    for (int k = 0; k <= n - i; k++) {
		if (str.charAt(k) == str.charAt(k + i - 1) && table[k + 1][k + i - 2] > 0) {
		    table[k][k + i - 1] = table[k + 1][k + i - 2] +2;
		    table[k + i - 1][k] = table[k + 1][k + i - 2] +2;
		}
	    }
	}

    }

    public static void print(int[][] arr, int n) {
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		System.out.print(arr[i][j]+"|");
	    }
	    System.out.println();
	    for (int j = 0; j < n; j++) {
		System.out.print("--");
	    }
	    System.out.println();
	}
    }
}
