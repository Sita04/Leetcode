package recursion_backtracking;

// Tags: Hard

public class Unique_Path_III_980 {

	/*
	 * Complexity: Time: O(3^n), Space: O(n)
	 */
	
    private int[][] grid;
    private int non_obstacles;
    private int path_count= 0;
    public int uniquePathsIII(int[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        
        this.grid= grid;
        
        int start_x= 0, start_y= 0, non_obstacles= 0;
        for(int i=0; i< grid.length; i++) {
            for(int j=0; j< grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    start_x= i;
                    start_y= j;
                }else if(grid[i][j] == 0) {
                    non_obstacles++;
                }
            }
        }
        
        this.non_obstacles= non_obstacles;
        grid[start_x][start_y]= -1;
        this.recurse(start_x-1, start_y, 0);
        this.recurse(start_x+1, start_y, 0);
        this.recurse(start_x, start_y-1, 0);
        this.recurse(start_x, start_y+1, 0);
        return path_count;
    }
    
    
    private void recurse(int i, int j, int count) {
        if(i < 0 || j< 0 || i >= grid.length || j >= grid[0].length
                        || grid[i][j] <= -1) {
            return;
        }
        if(grid[i][j] == 2 && count == non_obstacles) {
            path_count++;
            return;
        }
        
        int tmp= grid[i][j];
        grid[i][j]= -1;
        
        this.recurse(i+1, j, count+1);
        this.recurse(i-1, j, count+1);
        this.recurse(i, j-1, count+1);
        this.recurse(i, j+1, count+1);
        
        grid[i][j]= tmp;
        
    }
    
}
