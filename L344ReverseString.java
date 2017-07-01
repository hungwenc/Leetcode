/*344. Reverse String
Write a function that takes a string as input and returns the string reversed.
Example:
Given s = "hello", return "olleh".
*/
public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() <= 1) return s;
        char[] sarray = s.toCharArray();
        int i = 0;
        int j = sarray.length - 1;
        char temp;
        while(i<=j){
            temp = sarray[i];
            sarray[i] = sarray[j];
            sarray[j] = temp;
            i++;
            j--;
        }
        return new String(sarray);
    }
}


/*
Approach: Using Java Library
public class Solution {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}


Approach: Using Java Library
Java's library is probably slower that direct implementation due to extra overhead in check various edge cases such as surrogate pairs.
public class Solution {
    public String reverseString(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
}
Complexity Analysis

Time Complexity: `O(n log(n))` (Average Case) and `O(n * log(n))` (Worst Case) where `n` is the total number character in the input string. The recurrence equation is `T(n) = 2 * T(n/2) + O(n)`. `O(n)` is due to the fact that concatenation function takes linear time. The recurrence equation can be solved to get `O(n * log(n))`.

Auxiliary Space: `O(h)` space is used where `h` is the depth of recursion tree generated which is `log(n)`. Space is needed for activation stack during recursion calls.


*/
/*
public class L344ReverseString {
//	public String reverseString(String s) {
//	  	String temp = "";
//	  	char[] ch = s.toCharArray();
//		for (int i = s.length()-1; i>=0 ;i--){
//			temp = temp + ch[i];
//		}
//		return temp;
//	}
//	Not pass
//	Note
//	Java String is immutable, so by "re += c[i];", you are creating a new String object each time. Creating objects costs time, but what is worse is that when there are too many small objects which are no longer used, garbage collector starts to work, and this slows down the program. I guess this is the reason that your program exceeded time limit.
//	Interesting theory, but I don't think that's it. I added String t = "" + i; to your loop, which creates a new string each iteration and does slow down your time from 4ms to 20ms, still well within the allowed time.

	
	
//    public String reverseString(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        return sb.reverse().toString();
//    }
    public String reverseString(String s){
    	char[] word = s.toCharArray();
    	int i = 1;
    	int j = s.length()-1;
    	while(i<j){
    		char temp = word[i];
    		word[i] = word[j];
    		word[j] = temp;
    		i++;
    		j--;
    	}
    	return new String(word);
    }
