/*Lintcode 594. strStr II 
Implement strStr function in O(n + m) time.

strStr return the first index of the target string in a source string. The length of the target string is m and the length of the source string is n.
If target does not exist in source, just return -1.

Example
Given source = abcdef, target = bcd, return 1.
*/
// sol: Rabin-Karp -- time: O(n + m) 概念是用到hash function. n = len of source, m = len of target
// https://www.jianshu.com/p/d016030802bd
public class Solution {
    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
		int sourceLen = source.length();
        int targetLen = target.length();
        if (sourceLen < targetLen) {
            return -1;
        }
        if (targetLen == 0) {
            return 0;
        }
        
        final int MAGIC_NUM = 31;
        final int MODE = 1000000; // base
    
        int highestPower = 1;
        for (int i = 0; i < targetLen; i++) {
            highestPower = (highestPower * MAGIC_NUM) % MODE;
        }
        
        int targetCode = 0;
        for (int i = 0; i < targetLen; i++) {
            targetCode = (targetCode * MAGIC_NUM + target.charAt(i)) % MODE;
        }
        
        int sourceCode = 0;
        for (int i = 0; i < sourceLen; i++) {
            // abc + d
            sourceCode = (sourceCode * MAGIC_NUM + source.charAt(i)) % MODE;
            if (i < targetLen - 1) {
                continue;
            }
            //    i
            // abcd - a
            if (i >= targetLen) {
                sourceCode = sourceCode - (source.charAt(i - targetLen) * highestPower) % MODE;
                if (sourceCode < 0) {
                    sourceCode = sourceCode + MODE;
                }
            }
            
            // double check the string
            if (sourceCode == targetCode) {
                if (source.substring(i - targetLen + 1, i + 1).equals(target)) {
                    return i - targetLen + 1;
                }
            }
        }
        return -1;
    }
}
