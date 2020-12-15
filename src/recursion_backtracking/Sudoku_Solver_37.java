package recursion_backtracking;


// Tags: Hard

public class Sudoku_Solver_37 {

	/*
	 * Complexity: Time: Constant, Space: Constant (since board size is fixed)
	 */
	
    private boolean filled= false;
    private char[][] board;
    
    public void solveSudoku(char[][] board) {
        if(board.length == 0) {
            return;
        }
        
        this.board= board;
        this.backtrack(0,0);
    }
    
    private void backtrack(int i, int j) {
        if(i<0 || j < 0 || i>= board.length || j >= board[0].length) {
            return;
        }
        
        if(board[i][j] == '.') {
            for(int index= 1; index<= 9; index++) {
                if(isValueCompatible(i,j,index)) {
                    board[i][j]= (char) (index + '0');
                    this.getNextPosition(i, j);
                    if(!filled) {
                        board[i][j]= '.';
                    }
                }
            }
        }else {
            this.getNextPosition(i, j);
        }
        
    }
    
    private void getNextPosition(int x, int y) {
        if(y == board[0].length-1 && x == board[0].length-1) {
            filled= true;
        }
        
        if(y == board[0].length-1) {
            this.backtrack(x+1, 0);
        }else {
            this.backtrack(x, y+1);
        }
    }
    
    private boolean isValueCompatible(int i, int j, int k) {
        for(int x= 0; x< board.length; x++) {
            if(board[x][j] == (char) (k + '0')) {
                return false;
            }
        }
        for(int y= 0; y< board[0].length; y++) {
            if(board[i][y] == (char) (k + '0')) {
                return false;
            }
        }
        
        int board_x= (i / 3) * 3;
        int board_y= (j / 3) * 3;
        
        for(int x= board_x; x< board_x+3; x++) {
            for(int y= board_y; y< board_y+3; y++) {
                if(board[x][y] == (char) (k + '0')) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
