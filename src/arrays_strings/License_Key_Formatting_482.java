package arrays_strings;

// Tag: Easy

public class License_Key_Formatting_482 {

	/*
	 * Complexity: Time: O(n), Space: O(n)
	 */
    
    public String licenseKeyFormatting(String S, int K) {
    	if(S.length() == 0) {
            return "";
        }
    	
        StringBuilder sb= new StringBuilder();
        char[] charr= S.toUpperCase().toCharArray();
        int kCount= 0;
        
        for(int i= charr.length-1; i>= 0; i--) {
            if(charr[i] == '-') 
                continue;
            if(kCount % K == 0 && sb.length() > 0)
                sb.append("-");
            sb.append(charr[i]);
            kCount++;
        }
        
        return sb.length() == 0 ? "": sb.reverse().toString();
    }
    
    /*
     * Notes:
     * It might be beneficial to use the following and check for each character instead of converting
     * the entire String toUpperCase(). This reduces the time complexity by a factor 1/8th.
     * if(!Character.isDigit(charr[i]))
           charr[i]= Character.toUpperCase(charr[i]);
           
     * If we process the entire string first and then insert "-", at specific indices in the string, 
     * each StringBuilder.insert() method takes up O(n) time. This would significantly increase the time
     * complexity.
     */
	
}
