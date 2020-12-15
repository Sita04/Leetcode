package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

// Tags: Hard

public class N_Queens_51 {

	
	/*
	 * Complexity: Time: O(n!), Space: O(n) 
	 */
	
    private int n;
    private boolean[][] board;
    private List<List<String>> result= new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        if(n == 0 || n == 2) {
            return result;
        }
        
        this.n= n;
        this.board= new boolean[n][n];
        this.backtrack(0, 0);
        return result;
    }
    
    private int backtrack(int row, int count) {
        if(row< 0 || row>= n) {
            return count;
        }
        
        for(int col=0; col<n; col++) {
            if(board[row][col]) {
                return count;
            }
            if(canPlace(row, col)) {
                board[row][col]= true;
                count= this.backtrack(row+1, count+1);
                if(count == n) {
                    this.saveBoard();
                }
                board[row][col]= false;
                count--;
            }
        }
        return count;
    }
    
    
    private boolean canPlace(int i, int j) {
        for(int y=0; y< n; y++) {
            if(board[i][y]) {
                return false;
            }
        }
        
        for(int x= 0; x< n; x++) {
            if(board[x][j]) {
                return false;
            }
        }
        
        for(int x=0; x<n; x++) {
            for(int y=0; y<n; y++) {
                if(Math.abs(x-i) == Math.abs(y-j) && board[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void saveBoard() {
        List<String> list= new ArrayList<>();
        for(int i=0; i< n; i++) {
            StringBuilder sb= new StringBuilder();
            for(int j=0; j< n; j++) {
                if(board[i][j]) {
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        if(!result.contains(list))
            result.add(list);
        return;
    }
}
