/**
 * 83. Remove Duplicates from Sorted List
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */

/* recursive version
 * public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
}
*/
public class L83RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(head!=null && head.next!=null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }
}