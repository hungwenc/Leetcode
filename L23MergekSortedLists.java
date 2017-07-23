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

//http://www.jiuzhang.com/solutions/merge-k-sorted-lists/
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

/*
// sol 2: Divide & Conquer
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        
        return dummy.next;
    }
}

// sol 3: merge two by two
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        while (lists.size() > 1) {
            List<ListNode> new_lists = new ArrayList<ListNode>();
            for (int i = 0; i + 1 < lists.size(); i += 2) {
                ListNode merged_list = merge(lists.get(i), lists.get(i+1));
                new_lists.add(merged_list);
            }
            if (lists.size() % 2 == 1) {
                new_lists.add(lists.get(lists.size() - 1));
            }
            lists = new_lists;
        }
        
        return lists.get(0);
    }
    
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        
        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }
        
        return dummy.next;
    }
}
*/
