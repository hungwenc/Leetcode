/**
21. Merge Two Sorted Lists 
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.
 */
public class L21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        if(node1==null && node2 == null){
            return null;
        }else if(node1==null){
            return node2;
        }else if(node2==null){
            return node1;
        }
        ListNode ans = new ListNode(-1);
        ListNode head = ans;
        while(true){
            if(node1 == null){
                ans.next = node2;
                ans = ans.next;
                break;
            }
            if(node2 == null){
                ans.next = node1;
                ans = ans.next;
                break;
            }
            if(node1.val <= node2.val){
                ans.next = node1;
                ans = ans.next;
                node1 = node1.next;
            }else{
                ans.next = node2;
                ans = ans.next;
                node2 = node2.next;
            }
        }
        return head.next;
        
    }
}