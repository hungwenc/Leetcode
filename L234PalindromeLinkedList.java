/* L234. Palindrome Linked List
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class L234PalindromeLinkedList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast!=null){ // odd nodes: let right half smaller
            slow = slow.next;
        }
        ListNode left_head = head;
        ListNode right_head = reverse(slow);
        while(left_head!=null && right_head!=null){
            if(left_head.val != right_head.val){
                return false;
            }
            left_head = left_head.next;
            right_head = right_head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}
/*
This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example [1, 1, 2, 1].

In the beginning, set two pointers fast and slow starting at the head.

1 -> 1 -> 2 -> 1 -> null 
sf
(1) Move: fast pointer goes to the end, and slow goes to the middle.

1 -> 1 -> 2 -> 1 -> null 
          s          f
(2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.

1 -> 1    null <- 2 <- 1           
h                      s
(3) Compare: run the two pointers head and slow together and compare.

1 -> 1    null <- 2 <- 1             
     h            s
*/
