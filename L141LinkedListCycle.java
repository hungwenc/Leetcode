/**
 * 141. Linked List Cycle
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */

public class L141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}