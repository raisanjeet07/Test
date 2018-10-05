package com.san.ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Game2048 {
    
    public static Random random = new Random();

    public static void main(String[] args) {
	int[][] arr = {
		{0,0,0,2},
		{0,2,0,0},
		{0,0,2,0},
		{2,0,0,0}};
	int n = 4;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	String input = "";
	while(true){
	    print2D(arr);
	    System.out.println("Next Move pls..........");
	    try {
		input = reader.readLine().toUpperCase();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    switch(input){
	    
	    case "L" : moveLeft(arr, n);
	    	continue;
	    case "R" : moveRight(arr, n);
	    	continue;
	    case "U" : moveUp(arr, n);
	    	continue;
	    case "D" : moveDown(arr, n);
		continue;
	    }
	    System.out.println("Exiting game.......");
	    break;
	}

    }
    
    public static void moveRight(int arr[], int n) {
	int j = n-1;
	for(int i = j; i>= 0 ; i--){
	    if(arr[i] == 0)
		continue;
	    else{
		if(arr[j] == 0)
		    arr[j] = arr[i];
		else if(arr[j] == arr[i]){
		    arr[j] = 2*arr[j];
		    j--;
		}else{
		    j--;
		    arr[j] = arr[i];
		}
	    }
	    arr[i] = 0;
	}
    }
    
    public static void moveRight(int arr[][], int n) {
	for(int x = 0; x< n; x++){
	    int i = n-1;
	    for(int y = n-2; y > -1 ; y--){
		if(arr[x][y] == 0)
		    continue;
		else{
		    if(arr[x][i] == 0)
			arr[x][i] = arr[x][y];
		    else if(arr[x][i] == arr[x][y]){
			arr[x][i] = 2*arr[x][i];
			i--;
		    }else{
			i--;
			arr[x][i] = arr[x][y];
		    }
		}
		arr[x][y] = 0;
	    }
	    if(arr[x][i] > 0)
		i--;
	    int index = getRandomIndex(i, n-1);
	    if(index != -1)
	    arr[x][index] = 2;
	}
    }

    public static void moveLeft(int arr[][], int n) {
	for(int x = 0; x< n; x++){
	    int i = 0;
	    for(int y = 1; y < n ; y++){
		if(arr[x][y] == 0)
		    continue;
		else{
		    if(arr[x][i] == 0)
			arr[x][i] = arr[x][y];
		    else if(arr[x][i] == arr[x][y]){
			arr[x][i] = 2*arr[x][i];
			i++;
		    }else{
			i++;
			arr[x][i] = arr[x][y];
		    }
		}
		arr[x][y] = 0;
	    }
	    if(arr[x][i] > 0)
		i++;
	    int index = getRandomIndex(0, i);
	    if(index != -1)
	    arr[x][index] = 2;
	}
    }

    public static void moveUp(int arr[][], int n) {
	for(int y = 0; y< n; y++){
	    int i = 0;
	    for(int x = 1; x < n ; x++){
		if(arr[x][y] == 0)
		    continue;
		else{
		    if(arr[i][y] == 0)
			arr[i][y] = arr[x][y];
		    else if(arr[i][y] == arr[x][y]){
			arr[i][y] = 2*arr[i][y];
			i++;
		    }else{
			i++;
			arr[i][y] = arr[x][y];
		    }
		}
		arr[x][y] = 0;
	    }
	    if(arr[i][y] > 0)
		i++;
	    int index = getRandomIndex(i, n-1);
	    if(index != -1)
	    arr[index][y] = 2;
	    
	}
    }

    public static void moveDown(int arr[][], int n) {
	for(int y = n-1; y>-1; y--){
	    int i = n-1;
	    for(int x = n-2; x >-1 ; x--){
		if(arr[x][y] == 0)
		    continue;
		else{
		    if(arr[i][y] == 0)
			arr[i][y] = arr[x][y];
		    else if(arr[i][y] == arr[x][y]){
			arr[i][y] = 2*arr[i][y];
			i--;
		    }else{
			i--;
			arr[i][y] = arr[x][y];
		    }
		}
		arr[x][y] = 0;
	    }
	    if(arr[i][y] > 0)
		i--;
	    int index = getRandomIndex(0, i);
	    if(index != -1)
		arr[index][y] = 2;
	}
    }
    
    public static int getRandomIndex(int min, int max){
	if(min == max)
	    return -1;
	return random.nextInt(max - min) + min;
    }
    
    public static void print2D(int arr[][]){
	for(int a[] : arr)
	    System.out.println(Arrays.toString(a));
    }
}
