/*L567. Permutation in String
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
*/

// All letters are lower case, so we can use statistical way and sliding window to solve it.
public class Solution {
  public boolean checkInclusion(String s1, String s2) {
    int len1 = s1.length();
    int len2 = s2.length();
    if(len1 > len2) return false;

    int[] count = new int[26]; // record count of lower case letters
    for(int i = 0; i < len1; i++){
      count[s1.charAt(i) - 'a'] ++;
      count[s2.charAt(i) - 'a'] --;
    }
    
    if(helper(count)){
      return true;
    }

    // sliding window
    for(int i = len1; i < len2; i++){
      count[s2.charAt(i) - 'a'] --;
      count[s2.charAt(i-len1) - 'a'] ++;
      if(helper(count)){
        return true;
      }        
    }
    return false;        
  }
  private boolean helper(int[] count){
    for(int i = 0; i < count.length; i++){
      if(count[i] != 0){
        return false;
      }
    }
    return true;
  }
}
