/*Lintcode 363. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.
Trapping Rain Water
Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/
//https://www.lintcode.com/en/problem/trapping-rain-water/
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights == null || heights.length <= 2) return 0;
        
        int sum = 0;
        int i;
        int j;
        int k;
        boolean find_right = false;
        boolean find_left = false;

        int left_h_max = 0; // left heightest one
        int right_h_max = 0; // right heightest one 
        
        for(i = 0; i < heights.length; i++){
            if(i==0 || i == (heights.length-1)){
                continue;
            }
            for(j = i+1; j < heights.length; j++){
                if(heights[j] > heights[i]){
                    find_right = true;
                    right_h_max = Math.max(right_h_max, heights[j]);
                }
            }
            for(k = i-1; k >= 0; k--){                
                if(heights[k] > heights[i]){
                    find_left = true;
                    left_h_max = Math.max(left_h_max, heights[k]);
                }
            }
            if(find_right == true && find_left == true){
                sum = sum + 1 * (Math.min(left_h_max, right_h_max) - heights[i]);
            }
            //reset
            right_h_max = 0;
            left_h_max = 0;
            find_right = false;
            find_left = false;
        }
        return sum;
    }
}
