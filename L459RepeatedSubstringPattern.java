/*L459. Repeated Substring Pattern
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"
Output: False

Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/
//如果這個String s可以分割成子字串，那該子字串的長度一定小於s.length()/2
//最佳解是KMP算法
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() <= 1 || s.length() > 10000) return false;
        int len = s.length();
        int i;
        for(i = len/2; i >= 1; i--){
            String temp = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            if(len % temp.length() == 0){
                while(sb.length() < len){
                    sb.append(temp);
                }
                // remember using toString() to do type casting from StringBuilder to 'String' 
                if(sb.toString().equals(s)){ 
                    return true;
                }
            }
        }
        return false;
    }
}
