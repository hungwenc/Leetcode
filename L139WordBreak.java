/*L139. Word Break
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/

// n = s.length()
//time comp O(n^2)
//space comp O(n)
//http://www.programcreek.com/2012/12/leetcode-solution-word-break/

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] match = new boolean[s.length() + 1];  // record past 
        // match[i] which means from 0 to i-1 match
        match[0] = true; // initial state

        // start from i = 1
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
               if(match[j] && wordDict.contains(s.substring(j, i))){  // optimize, if match[j] is false, then no need to check substring
                   match[i] = true;
                   break;
               }
            }
        }
        return match[match.length - 1]; // last element
    }
}

/* note
We use a boolean vector dp[]. dp[i] is set to true if a valid word (word sequence) ends there. The optimization is to look from current position i back and only substring and do dictionary look up in case the preceding position j with dp[j] == true is found.
*/
