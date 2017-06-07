/*L11. Container With Most Water
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container and n is at least 2.
*/
//two pointers
//Time  O(n)
//Space O(1)
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxArea(int[] height) {
        //let two pointers point to the left end and the right end
        int i = 0; //left end
        int j = height.length - 1; //right end
        while(i < j){
            max = Math.max(max, Math.min(height[i], height[j])*(j-i));
            if(height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
