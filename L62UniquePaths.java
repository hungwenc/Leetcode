/*L62. Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
Note: m and n will be at most 100.
*/
// sol1. dynamic programming, top-down approach, use memoization improve time compl
// path(start, end) = path(start, (r, c-1)) + path(start, (c, r - 1))
// time comp: O(m*n)
// space comp: O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        // validate input
        if(m < 0 || m > 100 || n < 0 || n > 100) return 0;
        if(m == 1 && n == 1) return 1;
        int[][] memo = new int[m][n];
        // Integer temp = -1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                memo[i][j] = -1;
            }
        }
        return count(m, n, m-1, n-1, memo); 
    }
    public int count(int m, int n, int r, int c, int[][] memo){
        if(r < 0 || c < 0) return 0;
        if(r == 0 && c == 0) return 1; // at the end
        if(memo[r][c] == -1){
            memo[r][c] = count(m, n, r - 1, c, memo) + count(m, n, r, c - 1, memo); // store the value to cache
        }
        return memo[r][c]; // directly use value that we stored in cache before
    }
}

// sol2 recursive sol
// time comp: O( 2^(m*n) )
// space comp: O(max(m,n))??? call stack
/*
class Solution {
    public int uniquePaths(int m, int n) {
        // validate input
        if(m < 0 || m > 100 || n < 0 || n > 100) return 0;
        return count(m, n, m-1, n-1); 
    }
    public int count(int m, int n, int r, int c){
        if(r < 0 || c < 0) return 0;
        if(r == 0 && c == 0) return 1; // at the end
        return count(m, n, r - 1, c) + count(m, n, r, c - 1);
    }
}
*/
