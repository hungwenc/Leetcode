/*L540. Single Element in a Sorted Array
Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
Note: Your solution should run in O(log n) time and O(1) space.
*/

/*
sol. binary search
case 1.  idx of mid is even
idx 0 1 2 3 4 
arr X X X X X (given from problem arr個數一定會是odd)
mid     ^
idx of mid = 2 (even)
idx of mid % 2 == 0
then if(arr[mid] == arr[mid + 1]) array右半個數為odd number  因此出現一次的數字會在右側
then if(arr[mid] == arr[mid - 1]) array左半個數為odd number  因此出現一次的數字會在左側

case 2. idx of mid is odd
idx 0 1 2 3 4 5 6 
arr X X X X X X X (given from problem arr個數一定會是odd)
mid       ^
idx of mid = 3 (odd)
idx of mid % 2 != 0
then if(arr[mid] == arr[mid + 1]) array右半個數為even number  因此出現一次的數字會在左側
then if(arr[mid] == arr[mid - 1]) array左半個數為even number  因此出現一次的數字會在右側
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left < right){
            mid = left + (right - left)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }else if((mid % 2 == 0 && nums[mid] == nums[mid-1]) || (mid % 2 != 0 && nums[mid] == nums[mid+1])){
                right = mid - 1; // search for half left
            }else{
                left = mid + 1; // search for half right                
            }
        }
        return nums[left];
    }
}
