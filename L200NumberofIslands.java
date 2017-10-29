/*L200. Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/
// dfs + connected component

//time O(m*n)
//space O(m*n) // worst case call stack
// 不使用boolean[][] visited, 直接把visited 過的grid 設成 '0'
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 ||  grid[0] == null || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        // boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++; 
                }
            }
        }         
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length) return;
        if(j < 0 || j >= grid[0].length) return;
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        }else{
            return;
        }
        return;
    }
}


/*
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 ||  grid[0] == null || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    dfs(grid, visited, i, j);
                    count++; 
                }
            }
        }         
        return count;
    }
    private void dfs(char[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || i >= grid.length) return;
        if(j < 0 || j >= grid[0].length) return;
        if(grid[i][j] == '1' && visited[i][j] == false){
            visited[i][j] = true;
            dfs(grid, visited, i+1, j);
            dfs(grid, visited, i-1, j);
            dfs(grid, visited, i, j+1);
            dfs(grid, visited, i, j-1);
        }else{
            return;
        }
        return;
    }
}
*/
