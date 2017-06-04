import java.util.*;
/* L82. Remove Duplicates from Sorted List II 
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/
public class L82RemoveDuplicatesfromSortedListII {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = head;
        dummy.next = head;
        
        while(fast!=null){
            while(fast.next!=null && fast.val==fast.next.val){ // find the last node of the duplications
                fast = fast.next;
            }
            if(slow.next!=fast){  //case1. detect dup
                slow.next = fast.next; // remove dup
                fast = fast.next; // update the position of the fast pointer
            }else{ //case2. no dup, move both pointers 
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
