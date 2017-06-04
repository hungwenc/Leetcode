import java.util.*;
/* L19. Remove Nth Node From End of List 
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass. 
 */
public class L19RemoveNthNodeFromEndofList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(head.next==null && n == 1) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode cur = dummy;
        ListNode fast = dummy;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        
        while(fast != null){
            fast = fast.next;
            slow = cur;
            cur = cur.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
