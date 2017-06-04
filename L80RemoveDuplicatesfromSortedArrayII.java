/*L80. Remove Duplicates from Sorted Array II
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/
// use Two Pointer
public class L80RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        // given "sorted array"
        int len = nums.length;
        int cur = 1; // cur: the element needed to be replaced 
        int count = 0;
        if(len==0){
            return 0;
        }else if(len==1){
            return 1;
        }else{
            for(int i = 1; i<len; i++){
                if(nums[i] == nums[cur-1]){
                    count++;
                    if(count >= 2){
                        continue;
                    }
                }else{
                    count = 0; //reset
                }
                nums[cur] = nums[i];
                cur++;
            }
        }
        return cur;
    }
}
/* better sol
Question wants us to return the length of new array after removing duplicates and that we don't care about what we leave beyond new length , hence we can use i to keep track of the position and update the array.

Remove Duplicates from Sorted Array(no duplicates) :

public int removeDuplicates(int[] nums) {
    int i = 0;
    for(int n : nums)
        if(i < 1 || n > nums[i - 1]) 
            nums[i++] = n;
    return i;
}
Remove Duplicates from Sorted Array II (allow duplicates up to 2):

public int removeDuplicates(int[] nums) {
   int i = 0;
   for (int n : nums)
      if (i < 2 || n > nums[i - 2])
         nums[i++] = n;
   return i;
}

*/