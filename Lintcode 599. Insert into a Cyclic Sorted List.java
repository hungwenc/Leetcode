/*Lintcode 599. Insert into a Cyclic Sorted List // amazon
Given a node from a cyclic linked list which has been sorted, 
write a function to insert a value into the list such that it remains a cyclic sorted list. 
The given node can be any single node in the list. Return the inserted new node.

 Notice
3->5->1 is a cyclic list, so 3 is next node of 1.
3->5->1 is same with 5->1->3

Example
Given a list, and insert a value 4:
3->5->1
Return 5->1->3->4
*/
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
// case要想清楚 第一次寫很久
public class Solution {
    public ListNode insert(ListNode node, int x) {
        ListNode newNode = new ListNode(x);
        if (node == null) {
            //沒有node 就放入這個點
            newNode.next = newNode; //自己連到自己 - cycle
            return newNode;
        }
        ListNode prev = null;
        ListNode curt = node;
        
        //find position to insert
        do {
            // move雙指針
            prev = curt;
            curt = curt.next;
            // case1: 5->1->3 insert 2
            if (x <= curt.val && x >= prev.val) {
                break;
            }
            // case2: 5->1->3 insert 6
            // case3: 5->1->3 insert -3
            if (prev.val > curt.val && (x > prev.val || x < curt.val)) {
                break;
            }
        } while (curt != node); //跑完一圈
        
        //insert
        newNode.next = curt;
        prev.next = newNode; 
        return newNode;
    }
}
