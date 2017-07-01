/* L557. Reverse Words in a String III
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        int temp = 0;
        char[] sarray = s.toCharArray();
        int i = 0;
        for(i = 0; i < sarray.length; i++){
            if(sarray[i] == ' '){
                rev(sarray, temp, i-1);
                temp = i + 1;
            }
        }
        rev(sarray, temp, i-1); // for the last word
        return new String(sarray);
        // wrong: return sarray.toString();
    }
    private void rev(char[] sarray, int i, int j){
        char temp;
        while(i<=j){
            temp = sarray[i];
            sarray[i] = sarray[j];
            sarray[j] = temp;
            i++;
            j--;
        }
    }
}

// wrong sol
/*
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        int temp = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                rev(s.substring(temp, i));
                temp = i + 1;
            }
        }
        return s;
    }
    private void rev(String s){
        int i = 0;
        int j = s.length()-1;
        char temp;
        while(i<=j){
//   charAt() returns the character. It is not a left side operand aka you cannot assign a value to it. 
//   Strings are immutable, which means you cannot change them (this seems to be your intention). Instead: create a new String and add to that
            temp = s.charAt(i);
            s.charAt(i) = s.charAt(j);
            s.charAt(j) = temp;
            i++;
            j--;
        }
    }
}
*/
