import java.util.HashMap;

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
public class Solution2 {
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
        ListNode sol;
        boolean find = false;
        boolean first = true;
        while(true){
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

    }
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        tracker.put(0, -1);
        tracker.put(1, 1);
        tracker.put(3, 3);
        tracker.put(2, 2);
        System.out.println(tracker.get(0));
    }
}