/*L133. Clone Graph
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:
       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *          label = x; 
 *          neighbors = new ArrayList<UndirectedGraphNode>(); 
 *      }
 * };
 */

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // edge case
        if (node == null) {
            return node;
        }
        
        // 1. from one node to get nodes
        ArrayList<UndirectedGraphNode> oldNodes = getNodes(node);
        
        // 2. clone nodes and provide mapping old<->new
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode oldNode : oldNodes) {
            map.put(oldNode, new UndirectedGraphNode(oldNode.label));
        }
         
        // 3. copy neighbors(edges)
        for (UndirectedGraphNode oldNode : oldNodes) {
            UndirectedGraphNode newNode = map.get(oldNode);
            for (UndirectedGraphNode oldNeighbor : oldNode.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(oldNeighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return map.get(node);
    }
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
