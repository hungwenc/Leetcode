/*5. Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example:
Input: "cbbd"
Output: "bb"
*/

// sol1 simple solution 直觀
// time O(n^2)
// space O(1)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(s == null || len < 2) return s;
        if(len > 1000) return null;
        String ans = s.substring(0, 1);
        for(int i = 0; i < len; i++){
            // odd case: expand from the center i
            String temp = expand(s, i, i);
            if(temp.length() > ans.length()) ans = temp;
            // even case: expand from the center i and i+1
            temp = expand(s, i, i+1);
            if(temp.length() > ans.length()) ans = temp;       
        }
        return ans;
    }
    private String expand(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        // when the start break out of loop start might be "-1", so substring should be 'start + 1' to 'end'
        return s.substring(start + 1, end);
    }
}

// sol2 dynamic progrmming
// time O(n^2)
// space O(n^2)
// analysis: https://leetcode.com/problems/longest-palindromic-substring/solution/
/*
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(s == null || len < 2) return s;
        if(len > 1000) return null;
        boolean[][] cache = new boolean[len][len];
        int max = 0;
        int ans_left = 0;
        int ans_right = 0;
        // substring boundary left and right
        for(int r = 0; r < len; r++){ // right boundary
            for(int l = 0; l <= r; l++){ // left boundary
                if(s.charAt(l) == s.charAt(r)){
                    if((r - l) <= 2){
                        cache[l][r] = true;
                    }else{
                        cache[l][r] = cache[l+1][r-1];
                    }
                    if(cache[l][r] == true && (r - l + 1) > max){
                        max = r - l + 1;
                        ans_left = l;
                        ans_right = r;
                    }
                }else{
                    cache[l][r] = false;
                }
            }    
        }
        return s.substring(ans_left, ans_right + 1);
    }
}
*/
