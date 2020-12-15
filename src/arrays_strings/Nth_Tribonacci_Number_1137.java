package arrays_strings;

// Tag: Easy

public class Nth_Tribonacci_Number_1137 {

	/*
	 * Recursion
	 * Complexity: Time: O(n), Space: O(n)
	 */
	
    private int[] cache;
    public int tribonacci_Recursive(int n) {
        cache = new int[n+1];
        return helper(n);
    }
    
    private int helper(int n) {
        if(n == 0)
            return 0;
        if(n < 3)
            return 1;
        if(cache[n] != 0)
            return cache[n];
        
        cache[n]= helper(n-1) + helper(n-2) + helper(n-3);
        return cache[n];
    }
	
	
	/*
	 * Bottom-up Dynamic Programming
	 * Complexity: Time: O(1), Space: O(n)
	 */
	
    public int tribonacci(int n) {
        int[] result= new int[n+1];
        if(n == 0)
            return 0;
        if(n < 3) 
            return 1;
        
        result[1]= 1;
        result[2]= 1;
        for(int i=3; i<= n; i++) {
            result[i]= result[i-1] + result[i-2] + result[i-3];
        }
        return result[n];
    }
}
