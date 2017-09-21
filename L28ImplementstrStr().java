/*L28. Implement strStr()
Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

//implement indexOf   
/*edge case: 
case1 "" ""    >> should return 0
case2 "abc" "" >> should return 0
*/
// time O(m*n)	
// space O(1)
// sol1
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || haystack == null) return -1;
        int i, j;
        for(i = 0; i < haystack.length() - needle.length() + 1; i++){
            for(j = 0; j < needle.length(); j++){
                if(haystack.charAt(i + j) != needle.charAt(j)){ 
                    break;
                }
            }
            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }
}

// better solution should use KMP algorithm
