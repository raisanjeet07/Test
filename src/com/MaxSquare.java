package com;

public class MaxSquare {
    static int[][] arr = { { 1,0,0,1 }, {0,0,1,0 }, {0,0,0,0 } };
    static int X = 3;
    static int Y = 4;
    static int[][] table = new int[X][Y];
    static int l = 0;
    static int x1 = -1;
    static int y1 = -1;

    public static void main(String[] args) {
	solve(X,Y,arr);
	System.out.println(x1 + "\t" + y1 + "\t" + l);
	print(table);
    }

    public static void method1() {
	int length = X < Y ? X : Y;
	for (int i = 2; i <= length; i++) {
	    for (int x = 0; x <= X - i; x++) {
		for (int y = 0; y <= Y - i; y++) {
		    if (isValidSquare(arr, x, y, i, X, Y)) {
			l = i;
			x1 = x;
			y1 = y;
		    }
		}
	    }
	}
	System.out.println(x1 + "\t" + y1 + "\t" + l);
    }

    public static boolean isValidSquare(int[][] arr, int x, int y, int length, int X, int Y) {
	int sum = 0;
	for (int i = x; i < x + length && i < X; i++) {
	    for (int k = y; k < y + length && k < Y; k++) {
		sum += arr[i][k];
	    }
	}
	return sum == length * length ? true : false;
    }

    public static int solve(int X,int Y, int arr[][]) {
	int[][] table = new int[X][Y];
	// copy the 1st row and 1st column of table from arr
	int squareCount = 0;
	for(int i = 0; i< X;i++)
	    for(int k = 0; k<Y;k++){
		if(arr[i][k] == 0)
		    squareCount++;
		else
		    arr[i][k] = -1;
	    }
	
	for (int i = 0; i < Y; i++){
	    table[0][i] = arr[0][i];
	}
	for (int i = 0; i < X; i++){
	    table[i][0] = arr[i][0];
	}
	for (int x = 1; x < X; x++) {
	    for (int y = 1; y < Y; y++) {
		if (arr[x][y] > -1) {
		    int tmp = getMin(table[x - 1][y], table[x][y - 1], table[x - 1][y - 1]) + 1;
		    table[x][y] = tmp;
		    if(tmp > 0)
			squareCount++;
		} else
		    table[x][y] = -1;
	    }
	}
	print(table);
	return squareCount;
    }

    public static int getMin(int a1, int a2, int a3) {
	return a1 < a2 ? (a1 < a3 ? a1 : a3) : a2 < a3 ? a2 : a3;
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
