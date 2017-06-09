/*L445. Add Two Numbers II
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/* sol1 by stack
if number of L1: n &　L2: m (n is larger than m)
time compl: O(n)
space compl: O(n)
Runtime: 120 ms / beat 2.38 % of java submissions.
*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        //O(n)
        while(l1!=null || l2!=null){
            if(l1!=null){
                s1.push(l1.val);
                l1 = l1.next;
            }
            if(l2!=null){
                s2.push(l2.val);
                l2 = l2.next;
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode temp = null;
        int sum = 0;
        int val1 = 0;
        int val2 = 0;
        int carry = 0;
        
        // O(n)
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()){
                val1 = s1.pop();
            }else{
                val1 = 0;
            }
            if(!s2.isEmpty()){
                val2 = s2.pop();
            }else{
                val2 = 0;
            }
            sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            // insert to the front of Linked List
            temp = new ListNode(sum);
            temp.next = cur.next;
            cur.next = temp;
        }
        
        
        if(carry == 1){
            temp = new ListNode(carry);
            temp.next = cur.next;
            cur.next = temp;   
        }
        return dummy.next;
    }
}
