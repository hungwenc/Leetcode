import java.util.*;
/**
 * @author hhh146578
 * Leetcode 94. Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
/*
solution: http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/
*/
//try without Stack!!!Morris Inorder Tree Traversal	
//https://www.youtube.com/watch?v=wGXB9OWhPTg

//much simpler solution
public class L94BinaryTreeInorderTraversal {
 public List<Integer> inorderTraversal(TreeNode root) {
 	List<Integer> list = new ArrayList<Integer>();
 	Stack<TreeNode> stack = new Stack<TreeNode>();
 	if(root==null) return list;
 	TreeNode cur = root;
 	while(cur!=null || !stack.isEmpty()){
 		if(cur!=null){
 			stack.push(cur);
 			cur = cur.left;
 		}else{
 			cur = stack.pop();
 			list.add(cur.val);
 			cur = cur.right;
 		}
 	}
	return list;
 }
 public static void main(String[] args) throws Exception{
 	L94BinaryTreeInorderTraversal inorder = new L94BinaryTreeInorderTraversal();
 	TreeNode tree = new TreeNode(1);
 	tree.right = new TreeNode(2);
 	tree.right.right = new TreeNode(10);

 	tree.right.left = new TreeNode(3);
 	List<Integer> list = inorder.inorderTraversal(tree);
 	System.out.println(list);
 }
}
//

// below is my version
//public class L94BinaryTreeInorderTraversal {
//    public List<Integer> inorderTraversal(TreeNode root) {
//    	List<Integer> list = new ArrayList<Integer>();
//    	Stack<TreeNode> stack = new Stack<TreeNode>();
//    	if(root==null) return list;
//    	TreeNode temp = root;
//    	while(temp.left!=null){
//    		stack.push(temp);
//    		temp = temp.left;
//    		stack.peek().left = null;
//    	}
//    	stack.push(temp);
//		stack.peek().left = null;
//
//		while(stack.isEmpty()==false){
//    		TreeNode popout = null;
//    		popout = stack.peek();
//    		if(popout.left!=null){
//    			stack.push(popout.left);
//    			popout.left = null;
//	    	}else if(popout.left==null && popout.right!=null){
//	    		stack.pop();
//		    	list.add(popout.val);
//	    		stack.push(popout.right);
//	    	}else if(popout.left==null && popout.right==null){
//	    		stack.pop();
//		    	list.add(popout.val);
//	    	}
//    	}
//		return list;
//    }
//    public static void main(String[] args) throws Exception{
//    	L94BinaryTreeInorderTraversal inorder = new L94BinaryTreeInorderTraversal();
//    	TreeNode tree = new TreeNode(1);
//    	tree.right = new TreeNode(2);
//    	tree.right.right = new TreeNode(10);
//
//    	tree.right.left = new TreeNode(3);
//    	List<Integer> list = inorder.inorderTraversal(tree);
//    	System.out.println(list);
//    }
//}



