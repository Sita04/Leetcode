package arrays_strings;

// Tags: Medium

public class Container_With_Most_Water_11 {
	
	/*
	 * Complexity: Time: O(n), Space: O(1)
	 */
	
	public int maxArea(int[] height) {
	    int area= 0, maxArea= 0;
	    int left= 0, right= height.length-1;
	    
	    while(left < right) {
	        area = (right-left) * Math.min(height[left], height[right]);
	        maxArea = Math.max(maxArea, area);
	        if(height[left] < height[right])
	            left++;
	        else
	            right--;
	    }
	    return maxArea;
	}
}

