/* Lintcode 544. Top k Largest Numbers
Given an integer array, find the top k largest numbers in it.
Example
Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].
*/
// easy
// sol1: minHeap, time: O(n logk)
public class Solution {
    // 宣告heapComparator這個變數 要放在class solution內部 
    public Comparator<Integer> heapComparator = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };
    public int[] topk(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, heapComparator);
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest number in minHeap
                // so it can keep k largest elements in minHeap
            }
        }
        int[] result = new int[k];
        while (!minHeap.isEmpty()){
            result[--k] = minHeap.poll();
        }
        return result;
    }
}

// sol2: quicksort
