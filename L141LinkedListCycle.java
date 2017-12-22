/*L141. Linked List Cycle
Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
*/
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
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(slow != fast) {
            if (fast == null || fast.next == null) { 
                //要判斷fast.next是否為null 不然fast.next.next會有問題
                return false;
            }
            fast = fast.next.next; //一次跳兩格
            slow = slow.next; //一次跳一格
        }
        return true;
    }
}
