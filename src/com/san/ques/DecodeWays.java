package com.san.ques;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DecodeWays {
    public int numDecodings(String A) {
	int[] tmp = new int[2];
        if(A.length() >= 1)
            tmp[0] = isValidAscii("" +A.charAt(0)) ? 1 : 0;
        if(tmp[0] == 0)
            return tmp[0];
        if(A.length() >=2){
            if(A.charAt(1) == '0' && !isValidAscii(A.charAt(0) + "" +A.charAt(1)))
        	return 0;
            int count = 0;
            if(isValidAscii(A.charAt(1)+""))
        	count++;
            if(isValidAscii(A.charAt(0) + "" +A.charAt(1)))
        	count++;
            tmp[1] = count;
        }
        int count = 0;
        for(int k = 2;k<A.length();k++){
            count = 0;
            if(isValidAscii(A.charAt(k)+""))
        	count = tmp[1];
            if(isValidAscii(A.charAt(k-1) + "" +A.charAt(k)))
        	count+= tmp[0];
            if(count == 0)
        	return 0;
            tmp[0] = tmp[1];
            tmp[1] = count;
            
        }
        return (int)tmp[1];
    }
    
    public boolean isValidAscii(String num){
	if(num.charAt(0) == '0')
	    return false;
        int tmp = Integer.parseInt(num);
        //System.out.println(tmp);
        return (tmp < 27 && tmp > 0);
    }
    
    
    public int climbStairs(int A) {
	int s1  = 1;
	int s2 = 2;
	if(A == 1)
	    return s1;
	if(A == 2)
	    return s2;
	int i = 3;
	int sum = 0;
	while(i < A){
	    sum = s1 + s2;
	    s1 = s2;
	    s2 = sum;
	}
	
	return s1 + s2;
    }
    
    
    public int jump(int[] arr) {
	int n = arr.length;
        int[] tmp = new int[n];
        if(n == 1)
            return 0;
        
        tmp[0] = 0;
        int q = 1;
        for(int k = arr[0]; k>0;k--,q++)
            tmp[q] = 1;
            
        for(int i = 1; i < n ; i++){
            int j = i+1;
            for(int k = arr[i]; k > 0 && j <= n-1 && tmp[i] > 0; k--,j++){
        	if(tmp[j] == 0)
        	    tmp[j] = tmp[i] +1;
        	else if(tmp[j] > tmp[i] +1)
        	    tmp[j] = tmp[i] +1;
            }
        }
        if(tmp[n-1] == 0)
            return -1;
        return tmp[n-1];
    }
    
    public int minDistance(String s1, String s2) {
	int a = 0;
        int[][] table = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i <= s2.length();i++){
            table[0][i] = i;
        }
        for(int i = 0; i <= s1.length();i++){
            table[i][0] = i;
        }
        for(int i  = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
        	if(s1.charAt(i-1) == s2.charAt(j-1)){
        	    table[i][j] = table[i-1][j-1] ;
        	    continue;
        	}
                table[i][j] = getMin( table[i-1][j-1] +1,table[i-1][j] +1,table[i][j-1] +1);
                print2D(table);
                System.out.println("----------------------");
            }
        }
        return table[s1.length()][s2.length()];
    }

    private int getMin(int a, int b, int c) {
	return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }
    
    public int lis(final int[] arr) {
        int[] table = new int[arr.length];
        for(int i =0; i<arr.length;i++)
            table[i] = 1;
        int max = 1;
        for(int i = 1; i < arr.length; i++){
            for(int k = 0; k < i; k++){
                if(arr[i] > arr[k] && table[i] < table[k]+1)
                    table[i] = table[k]+1;
                if(max < table[i])
                    max = table[i];
                
            }
        }
        return max;
    }
    
    public int solve(final int[] arr) {
        int n = arr.length;
        if(n == 1)
            return 1;
        int[][] table = new int[n][n];
        int prvElement = 0;
        int p = -1;
        int diff = 0;
        int max = 2;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n;j++){
                table[i][j] = 2;
                diff = arr[j] - arr[i];
                if(diff <= 0 )
                    prvElement = arr[i] - diff;
                else
                    prvElement = 2*arr[i] - arr[j];
                p = -1;
                for(int k = 0; k<i;k++)
                    if(arr[k] == prvElement)
                        p = k;
                
                if(p != -1)
                    table[i][j] = getMax(table[i][j], table[p][i]+1);
                if(table[i][j] > max)
                    max = table[i][j];
            }
        }
        return max;
    }
    public int getMax(int a, int b){
        return a > b ? a:b;
    }
    
    public int maxProfit(final int[] arr){
        int maxprofit = 0;
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i] < arr[i+1])
        	maxprofit+=arr[i+1] - arr[i];
            
        }
        return maxprofit;
    }
    
    public String[] wordBreak(String str, String[] B) {
        Set<String> dic = new HashSet<>();
        for(String s : B)
            dic.add(s);
        String tmp = "";
        List<String>[] list = new List[str.length()];
        for(int i = 0 ; i < str.length(); i++){
            for(int j = 0; j<=i; j++){
                tmp = str.substring(j, i+1);
                if(dic.contains(tmp)){
                    List<String> tmpList = list[i];
                    if(tmpList == null)
                        tmpList = new ArrayList<>();
                    tmpList = getAllSentances(list, tmpList,tmp ,j-1);
                    list[i] =  tmpList;
                }
            }
        }
        List<String> returnList = list[str.length()-1];
        String[] arr = {};
        if(returnList == null)
            return arr;
        arr = new String[returnList.size()];
        int i = returnList.size()-1;
        for(String s : returnList)
            arr[i--] = s;
        return arr;
    }
    
    private List<String> getAllSentances(List<String>[] list, List<String> tmpList, String str, int i) {
	if(i < 0)
	    tmpList.add(str);
	else{
	    List<String> l = list[i];
	    if(l == null)
		return tmpList;
	    for(String s : l)
		tmpList.add(s +" " + str);
	}
	return tmpList;
    }

    public static void main(String[] args) {
	String s = "aabbbabaaabbbabaabaab";
	String[] dict = {"bababbbb", "bbbabaa", "abbb", "a", "aabbaab", "b", "babaabbbb", "aa", "bb"};
	printArray(new DecodeWays().wordBreak(s,dict));
    }
    
    public static void print2D(int arr[][]){
	for(int a[] : arr)
	    System.out.println(Arrays.toString(a));
    }
    
    public static <T> void printArray(T[] arr){
	for(T t : arr)
	    System.out.println(t);
    }
    
}
