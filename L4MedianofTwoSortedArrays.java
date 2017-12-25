/*L4. Median of Two Sorted Arrays
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/
// time : O(log(m+n))
public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;
        if (len % 2 == 1) { // odd
            return findKth(A, 0, B, 0, len/2 + 1);
        } else { //even
            return (findKth(A, 0, B, 0, len/2) + findKth(A, 0, B, 0, len/2 + 1))/2.0;
            // 因為type 要double 所以要除 2.0 
        }
    }
    //分別在array A 和 array B放指針A_start 和指針 B_start
    //移動時表示前面 k/2就去掉了
    private double findKth (int[] A, int A_start,
                            int[] B, int B_start, 
                            int k) {
        if (A_start >= A.length) { // A空 取B
            return B[B_start + k - 1];// 因為array 取index 所以才減1
        }
        if (B_start >= B.length) { // B空 取A
            return A[A_start + k - 1];
        }
        
        //如果A B 都不空 且 k == 1
        if (k == 1) {
            return Math.min(A[A_start + k - 1], B[B_start + k - 1]);
        }
        
        // 用Integer.MAX_VALUE 來達成 如果其中一個array不夠k/2長時 保證扔長的那邊
        int A_key = A_start + k/2 - 1 < A.length
                    ? A[A_start + k/2 - 1]
                    : Integer.MAX_VALUE; 
                    
        int B_key = B_start + k/2 - 1 < B.length
                    ? B[B_start + k/2 - 1]
                    : Integer.MAX_VALUE;
                    
        if (A_key < B_key) { // 扔A
            return findKth(A, A_start + k/2, B, B_start, k - k/2);
        } else { // (B_key < A_key) 扔B
            return findKth(A, A_start, B, B_start + k/2, k - k/2);
        }
        
    } 
}
