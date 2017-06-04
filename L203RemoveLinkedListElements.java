import java.util.*;
/* 
203. Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
Ans: http://www.jiuzhang.com/solutions/remove-linked-list-elements/

*/
public class L203RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	head = dummy;
    	while(head.next!=null){
    		if(head.next.val == val){
    			head.next = head.next.next;
    		}else{ //** this part I made a mistake!!!!!!!
    			head = head.next;
    		}
    	}
    	return dummy.next;
    }
    public static void main(String[] args){
		ListNode input1 = new ListNode(0);
		ListNode input2 = new ListNode(9);
		ListNode input3 = new ListNode(4);
		ListNode input4 = new ListNode(10);
		input1.next = input2;
		input2.next = input3;
		input3.next = input4;
		ListNode input = input1;
		while(input!=null){
			System.out.println(input.val);
			input = input.next;
		}
		System.out.println("above is input");

		ListNode output = removeElements(input1, 9);
		while(output!=null){
			System.out.println(output.val);
			output = output.next;
		}
    }
}