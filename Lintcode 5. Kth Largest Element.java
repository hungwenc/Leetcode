/*Lintcode 5. Kth Largest Element 
Find K-th largest element in an array.
Notice
You can swap elements in the array
Example
In array [9,3,2,4,8], the 3rd largest element is 4.
In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
*/
// quick select 練習 - time complexity: O(n)的平均時間複雜度
// 會比quicksort時間複雜度O(nlogn) 快的理由是 在quickselect時我們並沒有完成所以quicksort所需的步驟
class Solution {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    private int quickSelect(int[] nums, int start, int end, int k) {
        // 終止recursion的條件
        if (start == end) {
            System.out.println("find");
            return nums[start]; // 找到了
        }
        int left = start;
        int right = end;
        int pivot = nums[start + (end - start) / 2];
        while (left <= right) {
            // 注意 我們是找最大的 所以排列是 大 到 小 之前寫的quickSort都是從小到大排列
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        // 小心 不是 if (start + k <= right) 因為 極端case start == right 然後要找 k == 1 第一大的數 就會有問題
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k); //記得要return
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        // else 就是中間隔的那個數
        return nums[right + 1];
        
    }
};
