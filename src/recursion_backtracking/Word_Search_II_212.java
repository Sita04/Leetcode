package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;


// Tags: Hard

public class Word_Search_II_212 {

	
    private char[][] board;
    private List<String> result= new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0) {
            return result; 
        }
        this.board= board;
        
        loop: for(String word: words) {
            char start_char= word.charAt(0);
            for(int i=0; i< board.length; i++) {
                for(int j=0; j< board[0].length; j++) {
                    if(board[i][j] == start_char) {
                        if(isWordFound(i, j, word, 0)) {
                            result.add(word);
                            continue loop;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isWordFound(int i, int j, String word, int index) {
        if(index == word.length()) {
            return true;
        }
        
        if(i< 0 || j < 0 || i>= board.length || j >= board[i].length || 
                                board[i][j] != word.charAt(index)) {
            return false;
        }
        
        char tmp= board[i][j];
        board[i][j]= '-';
        boolean isFound= isWordFound(i-1, j, word, index+1) ||
            isWordFound(i+1, j, word, index+1) ||
            isWordFound(i, j-1, word, index+1) || 
            isWordFound(i, j+1, word, index+1);
        
        board[i][j]= tmp;
        return isFound;
    }
    
    /*
     * Notes: Words can be pre-processed to be stored in a Trie. So, that we effectively decrease the search space in each recursion.
     */
    
}
