import java.util.HashSet;
import java.util.Set;

public class Fifty50 {

    public static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
	System.out.println(solve(8, 0, 0));
    }
    static boolean solve(int g8, int g5, int g3) {
	String hash = g8 + "" + g5 + "" + g3;
	System.out.println(hash);
	if (g8 == 4 || g5 == 4)
	    return true;
	if (set.contains(hash)){
	    System.out.println(hash +"Same Loop");
	    return false;
	    }
	else set.add(hash);
	if(move8(g8, g5, g3)) return true;
	if(move5(g8, g5, g3)) return true;
	if(move3(g8, g5, g3)) return true;
	return false;
    }
    
    static boolean move3(int g8, int g5, int g3){
	if(g3 == 0)
	    return false;
	if((g8+g3)<9)
	    if(solve(g8+g3, g5, 0))
		return true;
	if(g3 - (5-g5) > -1 && g5 !=5)
	    if(solve(g8, g5 + (5 - g5), g3 - (5-g5))) return true;
	return false;
    }
    
    static boolean move5(int g8, int g5, int g3){
	if(g5 == 0)
	    return false;
	
	if((g8+g5)<9)
	    if(solve(g8+g5, 0, g3))
		return true;
	if(g5 - (3-g3) > -1 && g3 !=3)
	    if(solve(g8, g5 + (3 - g3), g3 + ((3-g3) - g5 <=0?(3-g3): g5))) return true;
	return false;
    }
    
    static boolean move8(int g8, int g5, int g3){
	if(g8 == 0)
	    return false;
	
	if(g8 - (5-g5) > -1 && g5 !=5)
	    if(solve(g8 - (5-g5), g5 + ((5-g5) - g8)<=0?(5-g5):g8 , g3)) return true;
	if(g8 - (3-g3) > -1 && g3 !=3)
	    if(solve(g8 - (3-g3), g5, g3+ ((3-g3) - g8 <=0?(3-g3): g8))) return true;

	return false;
    }

}
