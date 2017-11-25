/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// 透過inorder來判斷是否是valid的BST
public class Solution {
    List<Integer> list = new LinkedList<Integer>();
    boolean res = true; // global variable
    public List<Integer> inorder(TreeNode root) {
        if(root == null) return list;
        inorder(root.left);
        if(list.size()!=0){
            if(root.val <= list.get(list.size() - 1)) {
                res = false;
                return null;
            }
        }
        list.add(root.val);
        inorder(root.right);
        return list;
    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return res;
        
    }
}
/* from lint code
//sol1 traverse & inorder
// public class Solution {
//     boolean isValid = true;
//     private TreeNode lastNode = null;
//     public boolean isValidBST(TreeNode root) {
//         inOrder(root);
//         return isValid;
//     }
//     private void inOrder(TreeNode root) {
//         if(root == null){
//             return;
//         }
//         inOrder(root.left);
//         if(lastNode != null && root.val <= lastNode.val){
//             isValid = false;
//         }
//         lastNode = root;
//         inOrder(root.right);
//         return;
//     }
// }

//sol2 Divide and Conquer 
public class Solution {
    class ResultType{
        boolean is_bst;
        int maxValue;
        int minValue;
        public ResultType(boolean is_bst, int maxValue, int minValue) {
            this.is_bst = is_bst;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        ResultType result = helper(root);
        return result.is_bst;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            //注意這邊放的參數 是maxValue放 MIN_VALUE
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        //兩個子樹都必須是Binary Search Tree
        if (left.is_bst == false || right.is_bst == false) {
            // 因為是invalid bst 所以隨意傳入的max min值
            return new ResultType(false, -1, -1);
        }
        
        if (root.left != null && left.maxValue >= root.val ||
            root.right != null && right.minValue <= root.val) {
            return new ResultType(false, -1, -1);
        }

            
        return new ResultType(true,
                              Math.max(right.maxValue, root.val),
                              Math.min(left.minValue, root.val));
    }
}
*/
/* 
My simple Java solution in 3 lines
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
Basically what I am doing is recursively iterating over the tree while defining interval <minVal, maxVal> for each node which value must fit in.

---------------------------------------------------------------

Learn one iterative inorder traversal, apply it to multiple tree questions (Java Solution)
I will show you all how to tackle various tree questions using iterative inorder traversal. First one is the standard iterative inorder traversal using stack. Hope everyone agrees with this solution.

Question : Binary Tree Inorder Traversal

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    while(root != null || !stack.empty()){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        list.add(root.val);
        root = root.right;
        
    }
    return list;
}
Now, we can use this structure to find the Kth smallest element in BST.

Question : Kth Smallest Element in a BST

 public int kthSmallest(TreeNode root, int k) {
     Stack<TreeNode> stack = new Stack<>();
     while(root != null || !stack.isEmpty()) {
         while(root != null) {
             stack.push(root);    
             root = root.left;   
         } 
         root = stack.pop();
         if(--k == 0) break;
         root = root.right;
     }
     return root.val;
 }
We can also use this structure to solve BST validation question.

Question : Validate Binary Search Tree

public boolean isValidBST(TreeNode root) {
   if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
}
*/ 
