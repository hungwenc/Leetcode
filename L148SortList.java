/*L148. Sort List
Sort a linked list in O(n log n) time using constant space complexity.
*/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
// 把mergeSort 應用在linkedlist上
// time O(nlogn)
// space O(1)
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //找出linked list中間點 做mergeSort
        ListNode mid = findMid(head);
        
        ListNode right = sortList(mid.next);
        mid.next = null; // 記得要斷開 不然會無窮迴圈
        ListNode left = sortList(head);
        // 會是constant space 因為merge創的那個linked list在function 呼叫完後就沒占空間了
        return merge(left, right);
    }
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        
        if (left != null) {
            head.next = left;
        }
        
        if (right != null) {
            head.next = right;  
        }
        return dummy.next;
    }
}
