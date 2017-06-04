import java.util.*;
/**101. Symmetric Tree
Total Accepted: 168831
Total Submissions: 444809
Difficulty: Easy
Contributor: LeetCode
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */


//solution (recursive)
public class L101SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
	    return root==null || isSymmetricHelp(root.left, root.right);
	}

	private boolean isSymmetricHelp(TreeNode left, TreeNode right){
	    if(left==null || right==null)
	        return left==right;
	    if(left.val!=right.val)
	        return false;
	    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}
}


//solution (Non-recursive(use Stack))
/*
public class L101SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
	    if(root==null)  return true;
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode left, right;
	    if(root.left!=null){
	        if(root.right==null) return false;
	        stack.push(root.left);
	        stack.push(root.right);
	    }
	    else if(root.right!=null){
	        return false;
	    }
	        
	    while(!stack.empty()){
	        if(stack.size()%2!=0)   return false;
	        right = stack.pop();
	        left = stack.pop();
	        if(right.val!=left.val) return false;
	        
	        if(left.left!=null){
	            if(right.right==null)   return false;
	            stack.push(left.left);
	            stack.push(right.right);
	        }
	        else if(right.right!=null){
	            return false;
	        }
	            
	        if(left.right!=null){
	            if(right.left==null)   return false;
	            stack.push(left.right);
	            stack.push(right.left);
	        }
	        else if(right.left!=null){
	            return false;
	        }
	    }
	    
	    return true;
	}
}
*/


/* my version(recursive)
public class L101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        if(root.left==null || root.right==null) return false;
        if(root.left.val == root.right.val){
            return mirror(root.left, root.right);        
        }else{
            return false;
        }
    }
    public boolean mirror(TreeNode l, TreeNode r){
        if(l==null && r==null) return true;
        if(l==null || r==null) return false;
        if(l.val == r.val){
            return mirror(l.right, r.left) && mirror(l.left, r.right);
        }else{
            return false;
        }
    }
}
*/