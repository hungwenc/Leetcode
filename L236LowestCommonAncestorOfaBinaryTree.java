/*經典 L236. Lowest Common Ancestor of a Binary Tree
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
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
// video 公 https://www.youtube.com/watch?v=WqNULaUhPCc
// video https://www.youtube.com/watch?v=NBcqBddFbZw
/*
// 1. If the current subtree contains both p and q,
//    return their LCA.
// 2. If only one of them is in that subtree,
//    return that one of them.
// 3. If neither of them is in that subtree,
//    return the node of that subtree.
*/
// Time:  O(n)
// Space: O(h)
// 自己try case!
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // edge condition
        if(root == null) return null;
        if(p == root || q == root) return root;
        
        // divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // conquer
        if(left!=null && right!=null) return root; // 左右都有值 parent node 就是common ancestor
        if(left!=null) return left; // left!=null but right==null, 右邊傳上來的就是當前的root
        
        //else
        return right; // left==null but right!=null
    }
}

/*from lintcode
// divide and conquer
// 在root为根的二叉树中找A,B的LCA:
// 如果找到了就返回这个LCA
// 如果只碰到A，就返回A
// 如果只碰到B，就返回B
// 如果都没有，就返回null
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null){
            return null;    
        } 
        
        if (root == p || root == q){
          return root;//p q其中一個就是現在這個root
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null){
            return left;
        }
        if (right != null){
            return right;
        }
        return null;
    }
}
*/
