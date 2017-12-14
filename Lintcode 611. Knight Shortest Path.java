/*Lintcode 611. Knight Shortest Path 
Given a knight in a chessboard (a binary matrix with 0 (false) as empty and 1 (true) as barrier) with a source position, find the shortest path to a destination position, return the length of the route. 
Return -1 if knight can not reached.

Clarification
If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)
(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)
Example
[[0,0,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 2

[[0,1,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 6

[[0,1,0],
 [0,0,1],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return -1

*/
/**
 * Definition for a point.
 * public class Point {
 *     public int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
// 找考點: cause we wanna find shortest path -> thus using BFS!
public class Solution {
    boolean EMPTY = false; 
    boolean BARRIER = true;
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        int[] xdir = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] ydir = {2, -2, 2, -2, 1, -1, 1, -1};
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int step = 0;
        Queue<Point> queue = new LinkedList<>();
        //加第一個到queue
        queue.offer(source);
        // while隊列不空
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point head = queue.poll();
                if (head.x == destination.x && head.y == destination.y) {
                    return step;
                }
                for (int j = 0; j < xdir.length; j++) {
                    Point move = new Point(head.x + xdir[j], head.y + ydir[j]);
                    // make sure it is valid position in the chessboard
                    if (!isValid(grid, move)) {
                        continue;
                    }
                    queue.offer(move);
                    //記得要標記走過了!! 不然會死循環 stackoverflow
                    grid[move.x][move.y] = true; // 標記成BARRIER
                }
            }
            step++;
        }
        return -1;
    }
    public boolean isValid(boolean[][] grid, Point move) {
        int x = move.x;
        int y = move.y;
        //要先判斷邊界 再判斷是不是BARRIER
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == BARRIER) {
            return false;
        }
        return true;
    }
}
