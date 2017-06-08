/*L147. Insertion Sort List
Sort a linked list using insertion sort.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // time complexity: O(N^2)
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        
        // result list
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy; // help element will be inserted btw prev and prev.next
        
        // current head list
        ListNode cur = head; 
        ListNode next = null; // next element to be inserted
        
        while(cur != null){
            next = cur.next;// store the next node
            while(prev.next != null && prev.next.val < cur.val){
                prev = prev.next;
            }
            
            //else
            //prev.next == null or prev.next.val >= cur.val, then insert the element
            cur.next = prev.next;
            prev.next = cur;
            
            //update pointer
            prev = dummy;
            cur = next; 
        }
        return dummy.next;
    }
}
