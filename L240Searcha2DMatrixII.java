/*L240. Search a 2D Matrix II
Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,
Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.
Given target = 20, return false.
*/
//time compl: O(m + n)
//space compl: O(1)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // search from the top right corner
        if(matrix == null) return false;
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        if(col == 0) return false;
        int i = 0;
        int j = col - 1;
        int temp = 0;
        while(i < row && j >=0){
            temp = matrix[i][j];
            if(target < temp){
                j--;
            }else if(target > temp){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
