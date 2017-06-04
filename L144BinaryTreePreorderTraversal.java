import java.util.*;
/* L144. Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?


 */

//sol1 iteratively: Stack
public class L144BinaryTreePreorderTraversal {
    Stack<TreeNode> s = new Stack<TreeNode>();
    List<Integer> list = new LinkedList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return list;
        s.push(root);
        while(!s.empty()){
            TreeNode temp = s.pop();
            list.add(temp.val);
            if(temp.right!=null) s.push(temp.right);
            if(temp.left!=null) s.push(temp.left);
        }
        return list;
    }
}

//sol2 recursive
/*
public class Solution {
  List<Integer> list = new LinkedList<Integer>();
  public List<Integer> preorderTraversal(TreeNode root) {
      if(root==null) return list;
      list.add(root.val);
      preorderTraversal(root.left);
      preorderTraversal(root.right);
      return list;
  }
}
*/