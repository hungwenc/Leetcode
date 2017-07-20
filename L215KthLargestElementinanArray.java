/*L215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.
Note: 
You may assume k is always valid, 1 <= k <= array's length.
*/
// analysis: http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/

/*optimal sol*/
//sol1 Quick Select (average time comp:O(n)   worst case: O(N^2))
//time comp O(n)
// https://www.jiuzhang.com/solutions/kth-largest-element/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        if(k <= 0 || k > nums.length) return 0;
        if(nums.length == 1) return nums[0];
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    
    public int helper(int[] nums, int l, int r, int k){
        if(l == r){
            return nums[l];
        }
        // pivot position
        int position = partition(nums, l, r);
        if(position + 1 == k){
            return nums[position];    
        }else if(position + 1 < k){
            l = position + 1;
            return helper(nums, l, r, k);
        }else {
            r = position - 1;
            return helper(nums, l, r, k);
        }
    }
    
    // helper 
    private int partition (int[] nums, int l, int r){ // return pivot position
        // randomize to avoid worst case happens
        // Random rand = new Random();
        // int rand_idx = rand.nextInt(nums.length-1) + left;
        // exch(nums, nums.length-1, rand_idx);
        // divide into these three sections 
        // (smaller than the pivot), (equal to pivot value), (larger than the pivor)
        
        // init
        int left = l;
        int right = r;
        int pivot = nums[left];
        
        //patition
        while(left < right){
            while(left < right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
 
            while(left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
            // exch(nums, left, right);
        }
        nums[left] = pivot;
        return left;
    }
    // private void exch(int[] nums, int i, int j){
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    //     return;
    // }
}


//sol2
//time comp O(nlogn)
//space O(1)
//Java Arrays.sort: Quicksort is used for arrays of primitive types while mergesort for Object[] arrays.
//comparison-based sort and thus must have worst-case complexity Ω(n log n)
/*
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
*/


//sol3
//running time + O(K) memory
//time comp O(N lg K)
//space comp O(K)
/* pq
Java Priority Queue 
Priority queues are typically implemented using a heap. 
O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and  add); 
O(n) linear time for the remove(Object) and contains(Object) methods; 
O(1) constant time for the retrieval methods (peek,  element, and size).

If implemented as a sorted array, the head can be looked up and removed in O(1) since it is always the last element, 
but inserting new elements is O(n) since the insertion point needs to be found (which could be done in O(log(n)) using a binary search) 
and then all the later elements need to be shifted to make room, which is O(n).
*/
/*
Java PQ 使用方式
1. reverse Order 
ex.
PrioirtyQueue<String> pq = new PrioirtyQueue<String>(sQ.size(), Collections.reverseOrder());

2. Comparator 比較非integer的pq
ex.
private Comparator<Map.Entry<Integer, Integer>> Comparator = new Comparator<Map.Entry<Integer, Integer>>(){
    public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
        return m1.getValue() - m2.getValue();
    }
};
PrioirtyQueue<Map.Entry<Integer, Integer>> pq = new PrioirtyQueue<>(Comparator);
*/
/*
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
            if(pq.size() > k){
                // remove min
                pq.poll();
            }
        }
        return pq.peek();
    }
}
*/


