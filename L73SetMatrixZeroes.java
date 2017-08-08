/* L73. Set Matrix Zeroes
Given a m x n matrix, if an element is 0, 
set its entire row and column to 0. Do it in place.

click to show follow up.
Follow up:
Did you use extra space?
A straight forward solution using 'O(mn) space' is probably a bad idea.
A simple improvement uses 'O(m + n) space', but still not the best solution.
Could you devise a 'constant space' solution?
*/
public class Solution {
  public void setZeroes(int[][] matrix) {
    if(matrix == null || matrix[0] == null) return;
    int row = matrix.length; // row number
    int col = matrix[0].length; // col number

    // store first row or col should be zero or not
    boolean firstRowZero = false;
    boolean firstColZero = false;
    for(int j = 0; j < col; j++){
      if(matrix[0][j] == 0){
       firstRowZero = true;
       break;
      }    
    }
    for(int i = 0; i < row; i++){
      if(matrix[i][0] == 0){
       firstColZero = true;
       break;
      }    
    }
    
    // store records in first row or first col
    for(int i = 1; i < row; i++){
      for(int j = 1; j < col; j++){
        if(matrix[i][j] == 0){
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }  
    }
    
    for(int j = 1; j < col; j++){
      if(matrix[0][j] == 0){
        //set whole col zero
        for(int i = 1; i < row; i++){
          matrix[i][j] = 0;
        }
      }
    }

    for(int i = 1; i < row; i++){
      if(matrix[i][0] == 0){
        //set whole row zero
        for(int j = 1; j < col; j++){
          matrix[i][j] = 0;
        }
      }
    }
    
    // set first row or first col 
    if(firstRowZero == true){
      for(int j = 0; j < col; j++){
        matrix[0][j] = 0;
      }
    }
    if(firstColZero == true){
      for(int i = 0; i < row; i++){
        matrix[i][0] = 0;
      }
    }
  }
}
