/*Lintcode 598. Zombie in Matrix 
Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall. How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.
Example
Given a matrix:

0 1 2 0 0
1 0 0 2 1
0 1 0 0 0
return 2
*/
class Coordinate {
    int x;
    int y;
    public Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    } 
}
public class Solution {
    int ZOMBIE = 1;
    int PEOPLE = 0;
    int WALL = 2;
    public int zombie(int[][] grid) {
        //用大寫表達 而不是用magic nubmer
        int[] xdir = {-1, 0, 1, 0};
        int[] ydir = {0, 1, 0, -1};
        
        // validation
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        // count people
        int people = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == PEOPLE) {
                    people++;
                }
                if (grid[i][j] == ZOMBIE) {
                    queue.offer(new Coordinate(i, j));
                }
            }   
        }
        // corner case
        if (people == 0) {
            return -1;
        }
        // 用原先的array來代替set 去掉重複
        // 做BFS
        int days = 0;
        while (!queue.isEmpty()) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate zb = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Coordinate adj = new Coordinate(zb.x + xdir[j], zb.y + ydir[j]);
                    if (isPeople(adj, grid) == false) {
                        continue;
                    }
                    people--;
                    grid[adj.x][adj.y] = ZOMBIE;
                    if (people == 0) {
                        return days;
                    }
                    queue.offer(adj);
                }
            }
        }
        return -1;
    }
    public boolean isPeople(Coordinate adj, int[][] grid) {
        if (adj.x < 0 || adj.x >= grid.length || adj.y < 0 || adj.y >= grid[0].length) {
            return false;
        }
        return grid[adj.x][adj.y] == PEOPLE;
    }
}
