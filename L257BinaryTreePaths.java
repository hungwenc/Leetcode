import java.util.*;
/* L257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

 */
public class L257BinaryTreePaths {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null){ 
            search(root, "", answer);
        }
        return answer;
    }
    public void search(TreeNode root, String path, List<String> answer){
        if(root.left==null && root.right==null) answer.add(path + root.val);
        
        // recursive call
        if(root.left!=null) search(root.left, path + root.val + "->", answer);
        if(root.right!=null) search(root.right, path + root.val + "->", answer);
    }
}
