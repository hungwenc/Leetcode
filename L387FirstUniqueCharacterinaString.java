/*L387. First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. 
If it doesn't exist, return -1.
Examples:
s = "leetcode"
return 0.
s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/

//time complexity O(n)
public class Solution {
    public int firstUniqChar(String s) {
        //use ASCII code array
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 'a']==1) return i;
        }
        return -1;
    }
}
//  String substring(int beginIndex(包含), int endIndex(不包含))
// 擷取自指定位置 beginIndex 至 endIndex 的子字串。

