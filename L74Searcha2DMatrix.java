/*L74. Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,
Consider the following matrix:
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
//other related problems 
// http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/

//sol1. use Binary Search (and treat matrix as 1D array) 
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int r = matrix.length; // how many rows
        if(r <= 0 ) return false;
        int c = matrix[0].length; // how many columns
        if(c <= 0) return false;
        
        int start = 0;
        int end = r*c - 1;
        while(start <= end){
            int mid = start * 1 + (end - start)/2; 
            if(matrix[mid/c][mid%c] < target){
                start = mid + 1;
            }else if (matrix[mid/c][mid%c] > target){
                end = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}

/* other sols
Java clear solution
The basic idea is from right corner, if the current number greater than target col - 1 in same row, else if the current number less than target, row + 1 in same column, finally if they are same, we find it, and return return.
*/

