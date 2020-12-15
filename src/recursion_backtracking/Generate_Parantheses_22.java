package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

// Tags: Medium

public class Generate_Parantheses_22 {

	/*
	 * Complexity: Time: O(4^n)/ sqrt(n) , Space:  O(4^n)/ sqrt(n)
	 * Refer the complexity of nth Catalan number
	 */
	
    private List<String> result= new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 1) {
            result.add("()");
            return result;
        }
        permute("", 0, 0, n);
        return result;
    }
    
    private void permute(String current, int leftCount, int rightCount, int n) {
        if(current.length() == n * 2) {
            result.add(current);
            return;
        }
        
        if(leftCount < n)
            permute(current + "(", leftCount+1, rightCount, n);
        if(rightCount < leftCount)
            permute(current + ")", leftCount, rightCount+1, n);
    }
    
}
