/*L345. Reverse Vowels of a String
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
前後母音對換
 */
public class L345ReverseVowelsofaString {
    // vowel
    String vowel = "aeiouAEIOU";
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            char start_c = arr[start];
            char end_c = arr[end];
            if(vowel.contains(start_c + "") && vowel.contains(end_c + "")){
                arr[end] = start_c;
                arr[start] = end_c;
                start++;
                end--;
            }else if(vowel.contains(start_c + "")){//only find vowel in the start, wait until find vowel in the end
                end--;
            }else if(vowel.contains(end_c + "")){//only find vowel in the end, wait until find vowel in the start
                start++;;
            }else{
                start++;
                end--;
            }
        }
        //can use "String.valueOf(char[])" to conver char[] to String 
        return String.valueOf(arr);
    }
}
/*
StringBuffer

public int indexOf(int ch)
Returns the index within this string of the first occurrence of the specified character.
if no such character occurs in this string, then -1 is returned.
*/