package com.san.ques;

public class EqualStack {
    public static int solve(int[] s1, int[] s2, int[] s3){
	int h1 = sumUp(s1);
	int h2 = sumUp(s2);
	int h3 = sumUp(s3);
	int i = 0;
	int j = 0;
	int k = 0;
	
	boolean sameHeight = false;
	sameHeight = isAllEqual(h1, h2, h3);
	while((!sameHeight) && (i < s1.length && j < s2.length && k < s3.length)){
	    if(h1 > h2){
		if(h1 > h3){
		    // h1 is biggest
		    h1-=s1[i++];
		    sameHeight = isAllEqual(h1,h2,h3);
		}else{
		    // h3 is the biggest
		    h3-=s3[k++];
		    sameHeight = isAllEqual(h1,h2,h3);
		}
	    }else if(h2 > h3){
		// h2 is the biggest
		h2-=s2[j++];
		sameHeight = isAllEqual(h1,h2,h3);
	    }else{
		// h3 is the biggest
		h3-=s3[k++];
		sameHeight = isAllEqual(h1,h2,h3);		
	    }
	}
	if(sameHeight)
	    return h1;
	else 
	    return 0;
    }
    
    private static boolean isAllEqual(int h1, int h2, int h3){
	return (h1 == h2) && (h2 == h3);
    }
    
    private static int sumUp(int[] arr){
	int sum = 0;
	for(int i : arr)
	    sum +=i;
	return sum;
    }
    
    public static void main(String[] args) {
	int s1[] = {3,2,1,1,1};
	int s2[] = {4,3,2};
	int s3[] = {1,1,4,1};
	System.out.println(solve(s1, s2, s3));
    }
}
