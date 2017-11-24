/*L257. Binary Tree Paths
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//sol1 traverse
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null){ 
            search(root, "", answer);
        }
        return answer;
    }
    public void search(TreeNode root, String path, List<String> answer){
        if(root.left==null && root.right==null) answer.add(path + root.val);
        if(root.left!=null) search(root.left, path + root.val + "->", answer);
        if(root.right!=null) search(root.right, path + root.val + "->", answer);
    }
}

//sol2. divide conquer (lintcode)
/*
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        
        //recursion的出口
        if (root == null) {
            return paths;
        }
        
        //left (注意這題要考慮這個case)
        if (root.left == null && root.right == null) {
            paths.add(root.val + "");
            return paths;
        }
        
        //divide
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        
        for (String path : left) {
            paths.add(root.val + "->" + path);
        }
        for (String path : right) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }
}
*/
