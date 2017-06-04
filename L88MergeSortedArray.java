/* L88. Merge Sorted Array
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class L88MergeSortedArray {
//sol1 two pointer
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
        //idea. from the last element of two arrays. put the larger element to the end of the array nums1
        int i = m-1;
        int index = m + n - 1;
        int j = n-1;
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[index--] = nums1[i--];
            }else{
                nums1[index--] = nums2[j--];
            }
        }
        while(i>=0){
            nums1[index--] = nums1[i--];
        }
        while(j>=0){
            nums1[index--] = nums2[j--];
        }
    }

/* sol2 use function Arrays.sort()
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
        //sol1
        for(int i = m,  j = 0; (i < m + n) && (j < n) ; i++, j++){
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
        // return;
    }
*/
}
