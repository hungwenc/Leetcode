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
//BFS的解法
class Coordinate{
    int x;
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
} 

public class Solution {
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        // flood fill 灌水法, 能用寬度搜索就不要用深度搜索
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    Coordinate current = new Coordinate(i, j);
                    bfs(grid, current);
                    count++;
                }
            }            
        }
        return count;
    }
    
    // 在BFS中 這題利用grid matrix 來替代hash table
    private void bfs(boolean[][] grid, Coordinate current){
        // 四連通的問題
        int[] directionX = {-1, 0, +1, 0};
        int[] directionY = {0, +1, 0, -1};
        
        Queue<Coordinate> queue = new LinkedList<>();
        
        queue.offer(current);
        grid[current.x][current.y] = false;
        
        while (!queue.isEmpty()) {
            Coordinate head = queue.poll();
            for (int i = 0; i < directionX.length; i++) {
                Coordinate neighbor = new Coordinate(
                    head.x + directionX[i], 
                    head.y + directionY[i]
                );
                if (isBound(grid, neighbor) == false) {
                    continue;
                }
                if (grid[neighbor.x][neighbor.y]) { 
                    queue.offer(neighbor);
                    grid[neighbor.x][neighbor.y] = false;
                }
            }
        }
    }
    
    //處理matrix問題 記得要處理越界的case
    private boolean isBound(boolean[][] grid, Coordinate current){
        int row = grid.length;
        int col = grid[0].length;
        return current.x >= 0 && current.x < row && current.y >= 0 && current.y < col; 
    }
}

*/

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
