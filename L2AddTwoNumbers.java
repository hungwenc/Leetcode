/*L2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
*/

// Best solution: https://leetcode.com/problems/add-two-numbers/solution/
// Time complexity : O(\max(m, n))O(max(m,n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively, the algorithm above iterates at most \max(m, n)max(m,n) times.

// Space complexity : O(\max(m, n))O(max(m,n)). The length of the new list is at most \max(m,n) + 1max(m,n)+1.
//non-empty linked lists representing two non-negative integers
//single digit
// be careful to deal with last carry
// 342 + 465 = 807
// Follow up:　https://leetcode.com/problems/add-two-numbers-ii/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long time1, time2, time3;
        time1 = System.nanoTime();
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        int value1 = 0;
        int value2 = 0;
        while(l1!=null || l2!=null){
            
            if(l1 != null){
                value1 = l1.val;
                // update pointer
                l1 = l1.next;
            }else{
                value1 = 0;
            }
            
            if(l2 != null){ 
                value2 = l2.val;
                // update pointer
                l2 = l2.next;
            }else{
                value2 = 0;
            }
            
            int num = value1 + value2 + carry;
            
            //set number & carry
            carry = num / 10;
            num = num % 10;
            
            ListNode temp = new ListNode(num);
            cur.next = temp;
            
            // update pointers
            cur = cur.next;
        }
        
        if(carry != 0){
            cur.next = new ListNode(carry);
        }
        time3 = System.nanoTime();
        //System.out.println("first segment:" + (time2 -  time1));
        System.out.println("second segment:" + (time3 - time1));
        return dummy.next; 
    }
}
