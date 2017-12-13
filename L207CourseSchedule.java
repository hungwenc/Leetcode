/*L207. Course Schedule
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // validate input
        if (numCourses == 0 || prerequisites == null) {
            return true;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>(); // node and points to neighbors
        int[] indegree = new int[numCourses]; // node / indegree
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<Integer>());            
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (graph.get(prerequisites[i][1]).contains(prerequisites[i][0])) {
                continue;
            } 
            // tricky input可能輸入兩次 [9, 1], 所以照這個for loop計算的話indegree會是2
            //但其實圖上 可看出indegree 只有1
            indegree[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int head = queue.poll();
            count++;
            for (Integer neighbor : graph.get(head)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return count == numCourses;
    }
}
