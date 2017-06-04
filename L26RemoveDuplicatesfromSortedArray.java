/*L26. Remove Duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example,
Given input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class L26RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        // given "sorted array"
        int len = nums.length;
        int cur = 1;
        if(len==0){
            return 0;
        }else if(len==1){
            return 1;
        }else{
            for(int i = 1; i<len; i++){
                if(nums[i] != nums[cur-1]){
                    nums[cur] = nums[i];
                    cur = cur + 1;
                }
            }
        }
        return cur;
    }
}
