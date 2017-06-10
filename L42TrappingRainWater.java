/* L42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/
//idea: https://www.youtube.com/watch?v=8BHqSdwyODs

//sol1. use array (easy to understand)
//time O(n)
//space O(2*n)
// public class Solution {
//     public int trap(int[] height) {
//         int i = 0;
//         int j = 0;
//         int[] h = height;
//         if(h == null || h.length<=2) return 0;
//         int left = 0;
//         int right = 0;
//         int[] leftmax = new int[h.length];
//         int[] rightmax = new int[h.length];
//         int res = 0;
//         for(i = 0; i < h.length; i++){
//             if(i == 0){
//                 leftmax[i] = h[i];
//             }else{
//                 leftmax[i] = Math.max(leftmax[i-1], h[i]);
//             }
//         }
//         for(j = h.length-1; j >=0; j--){
//             if(j == h.length-1){
//                 rightmax[j] = h[j];
//             }else{
//                 rightmax[j] = Math.max(rightmax[j+1], h[j]);
//             }
//         }
        
//         //sum up
//         for(i = 0; i < h.length; i++){
//             res = res + 1 * (Math.min(leftmax[i], rightmax[i]) - h[i]);
//         }
//         return res;
//     }
// }

//sol2. two pointers (hard to understand)
//time O(n)
//space O(1)
public class Solution {
    public int trap(int[] height) {
        int[] h = height;
        if(h == null || h.length<=2) return 0;
        int i = 0;
        int j = h.length - 1;
        
        int leftmost = 0;
        int rightmost = 0;
        
        int res = 0;
        while(i <= j){
            leftmost = Math.max(leftmost, h[i]);
            rightmost = Math.max(rightmost, h[j]);
                        
            if(leftmost < rightmost){
                res = res + 1*(leftmost - h[i]);
                i++;
            }else{
                res = res + 1*(rightmost - h[j]);
                j--;
            }
        }
        return res;
    }
}
