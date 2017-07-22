//L23. Merge k Sorted Lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
//common problem in the distributed system，來自不同client端的sorted list要在central server merge起來
// N is total number of nodes, i.e., N = kn.
// n: the number of node each list has
//time compl: O(n *k * log(k))  因為priority queue的大小維持k 而每次插入的複雜度為log k
//space compl: O(k)  
//http://www.geeksforgeeks.org/merge-k-sorted-linked-lists/

//sol1. min heap priority queue
public class Solution {
    
    // implement comparator
    public class NodeComparator implements Comparator<ListNode> {
        // @override
        public int compare(ListNode a, ListNode b){
            return a.val - b.val; // min heap, poll the min value in the pq each time
            // < -1
            // == 0
            // > +1
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        if(lists == null || lists.length == 0) return dummy.next; // null
        NodeComparator cmp = new NodeComparator();
        PriorityQueue<ListNode> pq = new PriorityQueue<>(cmp);
        
        // add first element of each sorted lists
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null)  pq.offer(lists[i]);
        }
        
        ListNode cur = dummy; // serve as a pointer/cursor
        while(!pq.isEmpty()){
            ListNode temp = pq.poll(); // poll min in the pq
            cur.next = temp;
            cur = cur.next;
            if(temp.next != null){
                pq.offer(temp.next);
            }
        }
        return dummy.next;
    }
}
