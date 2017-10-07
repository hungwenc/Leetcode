//L21. Merge Two Sorted Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //soluion: iterative (more intuitive)
        ListNode node1 = l1;
        ListNode node2 = l2;
        if(node1==null && node2 == null){
            return null;
        }else if(node1==null){
            return node2;
        }else if(node2==null){
            return node1;
        }
        ListNode ans = new ListNode(-1);
        ListNode head = ans;
        while(true){
            if(node1 == null){
                ans.next = node2;
                ans = ans.next;
                break;
            }
            if(node2 == null){
                ans.next = node1;
                ans = ans.next;
                break;
            }
            if(node1.val <= node2.val){
                ans.next = node1;
                ans = ans.next;
                node1 = node1.next;
            }else{
                ans.next = node2;
                ans = ans.next;
                node2 = node2.next;
            }
        }
        return head.next;
        
        
        /*
        //solution recursive 
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        */
    }
}
