import java.util.*;
/* L409. Longest Palindrome
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class L409LongestPalindrome {
    public int longestPalindrome(String s) {
        //Assume the length of given string will not exceed 1,010.
        if(s == null) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        int res = 0;
        int odd_max = 0;
        boolean has_odd = false;
        for (Integer value : map.values() ) { 
            if( (value % 2) !=0){ // odd
                has_odd = true;
                res = res - 1;
            }
            res = res + value;
        }
        if(has_odd == true) return res + 1;
        return res;
    }
}
/* by hashset
public int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
}
*/