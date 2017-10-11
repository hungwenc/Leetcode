/*L63. Unique Paths II
Follow up for "L62. Unique Paths": https://leetcode.com/problems/unique-paths/description/
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 (obstacle) and 0 (empty space) respectively in the grid.
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
Note: m and n will be at most 100.
*/
// sol1. dynamic programming, top-down approach, use memoization improve time compl
// path(start, end) = path(start, (r, c-1)) + path(start, (c, r - 1))
// time comp: O(m*n)
// space comp: O(m*n)
// other smart ways: https://www.programcreek.com/2014/05/leetcode-unique-paths-ii-java/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // validate input
        if(obstacleGrid == null || obstacleGrid.length < 0 || obstacleGrid.length > 100 || 
          obstacleGrid[0].length < 0 || obstacleGrid[0].length > 100) return 0;
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] memo = new int[r][c];
        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j++){
                memo[i][j] = -1; // initialize with -1
            }
        }
        return count(obstacleGrid, r-1, c-1, memo); 
    }
    public int count(int[][] obstacleGrid, int r, int c, int[][] memo){
        if(r < 0 || c < 0) return 0;
        if(obstacleGrid[r][c] != 1){
            if(r == 0 && c == 0) return 1; // at the end
            if(memo[r][c] == -1){
                memo[r][c] = count(obstacleGrid, r - 1, c, memo) + count(obstacleGrid, r, c - 1, memo);
                // store the value to cache
            }
        }else{
            memo[r][c] = 0;
        }
        return memo[r][c]; // directly use value that we stored in cache before
    }
}
