package com.san.ques;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LSub {
    public static void main(String[] args) {
	List<Integer> a = Arrays.asList(100, 4, 3, 2, 1, 101, 102, 103, 104, 105, 106, 107, 108, 98, 99, 0);
	a = Arrays.asList(0, 8, 4, 12);
//	System.out.println(new LSub().longestSubsequenceLength(a));
	System.out.println(new LSub().solveAPSubSequence(a));
    }

    public int longestSubsequenceLength(final List<Integer> A) {
	Integer[] arr = new Integer[A.size()];
	int k = 0;
	for (Integer q : A)
	    arr[k++] = q;
	Integer[] s1 = solveDP(arr);
	// System.out.println(Arrays.toString(arr));
	rvereseArray(arr, 0, arr.length - 1);
	Integer[] s2 = solveDP(arr);
	rvereseArray(s2, 0, arr.length - 1);
	int max = 0;
	int tmp = 0;
	for (int i = 0; i < arr.length; i++) {
	    tmp = s1[i] + s2[i];
	    if (max < tmp)
		max = tmp;
	}
	System.out.println(Arrays.toString(s1));
	System.out.println(Arrays.toString(s2));
	return max - 1;
    }

    public Integer[] solveDP(Integer[] arr) {
	if (arr.length == 0)
	    return arr;
	Integer[] tmp = new Integer[arr.length];
	for (int i = 0; i < arr.length; i++)
	    tmp[i] = 1;
	tmp[0] = 1;
	for (int i = 1; i < arr.length; i++) {
	    for (int k = 0; k < i; k++) {
		if (arr[k] < arr[i] && tmp[i] < tmp[k] + 1)
		    tmp[i] = tmp[k] + 1;
	    }
	}
	return tmp;
    }

    void rvereseArray(Integer arr[], int start, int end) {
	int temp;

	while (start < end) {
	    temp = arr[start];
	    arr[start] = arr[end];
	    arr[end] = temp;
	    start++;
	    end--;
	}
    }

    public int solveAPSubSequence(final List<Integer> A){
	Integer[] arr = new Integer[A.size()];
	int k = 0;
	for (Integer q : A)
	    arr[k++] = q;
	return solveAPSubSequence(arr);
    }
    
    public int solveAPSubSequence(Integer[] arr) {
	Map<Integer, Integer> map = new HashMap<>();
	int count = 1;
	int tmp = 0;
	int diff = 0;
	for (int i = 1; i < arr.length; i++) {
	    for (int k = 0; k < i; k++) {
		diff = arr[i] - arr[k];
		if (map.containsKey(diff)) {
		    tmp = map.get(diff) +1;
		    map.put(diff, tmp);
		} else {
		    tmp = 2;
		    map.put(diff, tmp);
		}
		if(count < tmp)
		    count = tmp;
	    }
	}
	return count;
    }

}
