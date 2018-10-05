package com.san.ques;

public class GameOfTwoStack {

    public static int solve(int x, int[] s1, int[] s2, int s1StartIndex, int s2StartIndex){
	
	if(s1StartIndex < s1.length && s1StartIndex < s1.length & x > 0){
	    int includeFromS1 = solve(x - s1[s1StartIndex], s1, s2, s1StartIndex+1, s2StartIndex);
	    int excludeFromS2 = solve(x - s2[s2StartIndex], s1, s2, s1StartIndex, s2StartIndex+1);
	    return (includeFromS1 > excludeFromS2 ? includeFromS1 : excludeFromS2)+1;
	}else
	    return 0;
    }
    
}
