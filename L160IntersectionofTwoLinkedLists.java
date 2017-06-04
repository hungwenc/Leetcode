import java.util.*;
/**
 * 160. Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 ¡÷ a2
                   ¡û
                     c1 ¡÷ c2 ¡÷ c3
                   ¡ù            
B:     b1 ¡÷ b2 ¡÷ b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class L160IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length_A = 0;
        int length_B = 0;
        ListNode temp_A = headA;
        ListNode temp_B = headB;
        while(temp_A!=null){
            length_A ++;
            temp_A = temp_A.next;
        }
        while(temp_B!=null){
            length_B ++;
            temp_B = temp_B.next;
        }
        int dist = 0;
        if(length_A > length_B){
            dist = length_A - length_B;
            for(int i = 0 ; i < dist ; i++){
            	headA = headA.next;
            }
        }else{
            dist = length_B - length_A;
            for(int i = 0 ; i < dist ; i++){
            	headB = headB.next;
            }
        }
        ListNode sol = null;
        boolean find = false;
        boolean first = true;
        while(headA!=null){
            if(headA.val == headB.val){
                find = true;
                if(first == true){
                    sol = headA;
                    first = false;
                }
            }else{
                find = false;
            }
            headA = headA.next;
            headB = headB.next;
        }
        if(find == false){
            return null;
        }else{
            return sol;
        }
    }
}