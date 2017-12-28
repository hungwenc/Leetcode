/*Lintcode 143. Sort Colors II 
Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
Notice
You are not suppose to use the library's sort function for this problem.

k <= n
Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
*/
public class Solution {
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        // 1 到 k 顏色範圍
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }
    public void rainbowSort(int[] colors,
                            int left,
                            int right,
                            int colorFrom,
                            int colorTo) {
        // 受限這個範圍 這邊很像mergeSort - colorFrom colorTo
        if (colorFrom == colorTo) {
            return;
        }
        
        if (left >= right) {
            return;
        }

        // patition 部分很像 quicksort
        int colorMid = (colorFrom + colorTo)/2;
        int l = left;
        int r = right;
        while (l <= r) {
            while (l <= r && colors[l] <= colorMid) {
                l++;
            }
            while (l <= r && colors[r] > colorMid) {
                r--;
            }
            if (l <= r) {
                int temp = colors[l];
                colors[l] = colors[r];
                colors[r] = temp;
                l++;
                r--;
            }
        }
        rainbowSort(colors, left, r, colorFrom, colorMid);
        rainbowSort(colors, l, right, colorMid + 1, colorTo);
    }
}
