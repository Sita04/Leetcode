package arrays_strings;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters_3 {

    public int lengthOfLongestSubstring(String s) {
        int start=0, max= 0;
        if(s.length() == 0)
            return 0;
        
        HashMap<Character, Integer> map= new HashMap<>();
        for(int i=0; i< s.length(); i++) {
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start)
                start= map.get(s.charAt(i))+1;
            else
                max= Math.max(i-start+1, max);
            map.put(s.charAt(i), i);
        }
        return max;
    }
	
}
