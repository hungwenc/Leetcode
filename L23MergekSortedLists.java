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

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
//三種解法都要寫寫看
// sol1 heap priorityQueue 最容易寫解法 time complexity = O(N logK)
public class Solution {
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    };
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        
        for (int i = 0 ; i < lists.size(); i++) {
            ListNode node = lists.get(i);
            if (node != null) {
                pq.add(node);
            }
        }

        while (!pq.isEmpty()){ // O(N) N 為總共的node的數
            ListNode minNode = pq.poll(); // pq 的 poll time complextity O(logK)
            tail.next = minNode;
            tail = tail.next;
            if (minNode.next != null) {
                pq.add(minNode.next); // pq 的 add time complextity O(logK)
            }
        }
        return dummy.next;
    }
}

// sol2 merge two by two 解法 bottom -> up, time complexity = O(N logK)
/*
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        while (lists.size() > 1) {  // 表示可以繼續的merge
            List<ListNode> newList = new ArrayList<>();
            for (int i = 0; i + 1 < lists.size(); i = i + 2) { // 這裡bound 應該要 i+1 < size
                ListNode mergedList = mergeTwoLists(lists.get(i), lists.get(i + 1));
                newList.add(mergedList);
            }
            if (lists.size() % 2 == 1) {
                newList.add(lists.get(lists.size() - 1));
            }
            lists = newList;
        }
        return lists.get(0);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode lastNode = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        
        if (l1 != null) {
            lastNode.next = l1;
        }
        if (l2 != null) {
            lastNode.next = l2;
        }
        return dummy.next;
    }
}
*/

// sol3 Divide & Conquer 解法 top -> down,(很像mergeSort寫法) time complexity = O(N logK)
/*
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }

        return mergeHelper(lists, 0, lists.size() - 1);
    }
    public ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start >= end) {
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode lastNode = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        
        if (l1 != null) {
            lastNode.next = l1;
        }
        if (l2 != null) {
            lastNode.next = l2;
        }
        return dummy.next;
    }
}
*/
/*
//min heap priority queue
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
*/
