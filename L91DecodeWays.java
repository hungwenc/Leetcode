/*L91. Decode Ways
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
The number of ways decoding "12" is 2.
*/
// video https://www.youtube.com/watch?v=hFuj6GaaGpY
// idea https://segmentfault.com/a/1190000003813921

// sol1 dp with memorization
//time  O(n)
//space O(n)
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; // why set 1? cause we have to let dp[2] be correct answer
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;
        int i;
        for(i = 2; i <= s.length(); i++){
            int twoDigits = Integer.valueOf(s.substring(i-2, i));
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            if(twoDigits >= 10 && twoDigits <= 26){ // valid two digits
               dp[i] =  dp[i] + dp[i-2]; 
            }
               
            if(oneDigit >= 1 && oneDigit <= 9){
                dp[i] =  dp[i] + dp[i-1];
            }
        }
        return dp[dp.length - 1];
    }
}


// sol2 (better solution) dp with memorization (optimize space)
//time  O(n)
//space O(1)
/*
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int prev = 1;
        int curr = (s.charAt(0) == '0') ? 0 : 1;

        int i;
        for(i = 2; i <= s.length(); i++){
            int twoDigits = Integer.valueOf(s.substring(i-2, i));
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int temp = curr;
            if(twoDigits >= 10 && twoDigits <= 26){ // valid two digits
               dp[i] =  dp[i] + dp[i-2]; 
            }
               
            if(oneDigit >= 1 && oneDigit <= 9){
               dp[i] =  dp[i] + dp[i-1];                    
            }
            prev = temp;
        }
        
        return curr;
    }
}
*/
