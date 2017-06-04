import java.util.*;
/* L100 Same Tree
 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Subscribe to see which companies asked this question.

Show Tags

*/

//concise sol version
//java function 回傳值 不一定要有人去接收
public class L100SameTree {
	 public boolean isSameTree(TreeNode p, TreeNode q) {
	     if(p == null && q == null){
	         return true;
	     }
	     if(p == null || q == null){
	         return false;
	     }
	     if(p.val != q.val){
	         return false;
	     }
	     return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	 }
}


// my version
//public class L100SameTree {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p == null && q == null){
//            return true;
//        }else if(p != null && q == null){
//            return false;
//        }else if(q != null && p == null){
//            return false;
//        }
//        boolean left = isSameTree(p.left, q.left);
//        if(left == false){
//            return false;
//        }
//        if(p.val != q.val){
//            return false;
//        }
//        boolean right = isSameTree(p.right, q.right);
//        if(right == false){
//            return false;
//        }
//        return true;
//    }
//}
