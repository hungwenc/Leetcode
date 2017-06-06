/*L350. Intersection of Two Arrays II
Given two arrays, write a function to compute their intersection.
Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> res_array = new ArrayList<Integer>();
        for(int i = 0 ; i < len1; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }else{
                map.put(nums1[i], 1);
            }
        }

        for(int i = 0 ; i < len2; i++){
            if(map.containsKey(nums2[i])){
                map.put(nums2[i], map.get(nums2[i]) - 1);
                if(map.get(nums2[i]) == 0){
                    map.remove(nums2[i]);
                }
                res_array.add(nums2[i]);
            }
        }
        int[] ans = new int[res_array.size()];
        int i = 0;
        for(Integer key : res_array){
            ans[i++] = key;
        }
        return ans;
    }
}
