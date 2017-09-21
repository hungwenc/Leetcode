/*L38. Count and Say
The count-and-say sequence is the sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"
*/
//dynamic programming
//time O(n * 2^n)
//space O(2^n)	
class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        String str = "1";
        if(n == 1) return str;
        for(int i = 2; i <= n; i++){
            int count = 0;
            char prev = '.'; // store the previous character
            StringBuilder sb = new StringBuilder();
            for(int idx = 0; idx < str.length(); idx++){
                if(str.charAt(idx) == prev || prev == '.'){
                    count++;
                }else{
                    // remember to do type casting
                    sb.append(count + Character.toString(prev));
                    count = 1;
                }
                prev = str.charAt(idx);
            }
            
            sb.append(count + Character.toString(prev));
            str = sb.toString();
        }
        return str;
    }
}
