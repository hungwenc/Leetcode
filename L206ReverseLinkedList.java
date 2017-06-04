import java.util.*;
public class L206ReverseLinkedList {
	public static ListNode reverseList(ListNode head){
		ListNode prev = null;
		ListNode after = null;
		ListNode current = null;
		current = head;
		boolean first = true;
		while(current != null){
			if(current.next != null){
				prev = current.next;
				if(first == true){
					current.next = null;
					first = false;
				}else{
					current.next = after;
				}
				after = current;
				current = prev;
			}else{
				current.next = after;
				break;
			}
		}
		ListNode output = current;
		return output;
	}
//	//Java Solution 1 - Iterative
//	public ListNode reverseList(ListNode head) {
//	    if(head==null||head.next==null)
//	        return head;
//	 
//	    ListNode p1 = head;
//	    ListNode p2 = p1.next;
//	 
//	    head.next = null;
//	    while(p1!=null&& p2!=null){
//	        ListNode t = p2.next;
//	        p2.next = p1;
//	        p1 = p2;
//	        p2 = t;
//	    }
//	 
//	    return p1;
//	}
	
	//Java Solution 2 - Recursive
	public ListNode recursive_reverseList(ListNode head) {
	    if(head==null || head.next == null)
	        return head; //Step 1: Find out and set the endpoint for the recursive funciton.!!
	 
	    //get second node    
	    ListNode second = head.next;
	    //set first's next to be null
	    head.next = null;
	 
	    ListNode rest = reverseList(second);
	    second.next = head;
	 
	    return rest;
	}
	

	public static void main(String[] args){
		ListNode input1 = new ListNode(0);
		ListNode input2 = new ListNode(1);
		ListNode input3 = new ListNode(2);
		ListNode input4 = new ListNode(3);
		input1.next = input2;
		input2.next = input3;
		input3.next = input4;

		ListNode input = input1;
		while(input!=null){
			System.out.println(input.val);
			input = input.next;
		}
		ListNode output = reverseList(input1);
		while(output!=null){
			System.out.println(output.val);
			output = output.next;
		}
	}
}
