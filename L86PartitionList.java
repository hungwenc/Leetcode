/*L86. Partition List
Given a linked list and a value x, 
partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        //for bigger or equal to x
        ListNode dummy1 = new ListNode(-1);
        ListNode dum1 = dummy1;
        //for less than x 
        ListNode dummy2 = new ListNode(-1);
        ListNode dum2 = dummy2;
        while(head != null){
            ListNode temp = new ListNode(head.val);
            if(head.val >= x){
                dum1.next = temp;
                dum1 = dum1.next;
            }else{
                dum2.next = temp;
                dum2 = dum2.next;
            }
            head = head.next;
        }
        dum2.next = dummy1.next;
        return dummy2.next;
    }
}
