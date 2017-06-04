import java.util.*;
/* L142. Linked List Cycle II
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?


 */
public class L142LinkedListCycleII {
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	// idea: http://www.cnblogs.com/springfor/p/3862125.html 
	// idea:http://blog.csdn.net/qq508618087/article/details/50473996
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next==null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(true){
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        
        slow = head;
        
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    
// public class Solution {
//	     public ListNode detectCycle(ListNode head) {
//	         if (head == null || head.next==null) {
//	             return null;
//	         }

//	         ListNode fast, slow;
//	         fast = head.next;
//	         slow = head;
//	         while (fast != slow) {
//	             if(fast==null || fast.next==null)
//	                 return null;
//	             fast = fast.next.next;
//	             slow = slow.next;
//	         } 
	        
//	         while (head != slow.next) {
//	             head = head.next;
//	             slow = slow.next;
//	         }
//	         return head;
//	     }
// }


// public class Solution {
//	     public ListNode detectCycle(ListNode head) {
//	         if(head==null||head.next==null)
//	             return null;
	        
//	         ListNode fast = head,slow=head;
//	         while (true) {
//	             if (fast == null || fast.next == null) {
//	             return null;   
//	         }
//	             slow = slow.next;
//	             fast = fast.next.next;
	            
//	             if(fast==slow)
//	                 break;
//	         }
	        
//	         slow = head;//slow back to start point
//	         while(slow != fast){
//	             slow = slow.next;
//	             fast = fast.next;
//	         }
//	         return slow; //when slow == fast, it is where cycle begins
//	     }
// }

}
