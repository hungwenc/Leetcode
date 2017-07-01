/*L79. Word Search
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
For example,
Given board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
// Time:  O(m * n * word_length)
// Space: O(l)
public class Solution {
    public boolean exist(char[][] board, String word) {
		int m = board.length;
        int n = board[0].length;
        if(board == null || m == 0 || n == 0 || word == null || word.length() == 0) return false;

        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
            	if(dfs(board, word, i, j, 0)){
                    return true;
                }
        	}   
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int w_index){
        int m = board.length;
        int n = board[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n){
            return false;
        }
        char temp;
        if(word.charAt(w_index) == board[i][j]){
            temp = board[i][j];
            board[i][j] = '#'; // set visited ('#')
            if(w_index == word.length()-1){
                return true;
            }else if(dfs(board, word, i+1, j, w_index + 1) ||
                        dfs(board, word, i-1, j, w_index + 1) ||
                        dfs(board, word, i, j+1, w_index + 1) ||
                        dfs(board, word, i, j-1, w_index + 1) ){
                return true;
            }
            board[i][j] = temp; // reset visited
        }
        return false;
    }
}
