/*L210. Course Schedule II
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // validate input
        if (numCourses == 0 || prerequisites == null) {
            return new int[0];
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>(); // node and points to neighbors
        int[] indegree = new int[numCourses]; // node / indegree
        int[] result = new int[numCourses];
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
            result[count] = head;
            count++;
            for (Integer neighbor : graph.get(head)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if(count == numCourses) {
            return result;
        }
        return new int[0];
    }
}
