/*L520. Detect Capital
Given a word, you need to judge whether the usage of capitals in it is right or not.
We define the usage of capitals in a word to be right when one of the following cases holds:
All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
*/
public class Solution {
    public boolean detectCapitalUse(String word) {
        //The input will be a non-empty word consisting of uppercase and lowercase latin letters.        int i = 0;
        int len = word.length();
        if(len == 0) return false;
        char first = word.charAt(0);
        int i = 0;
        if(Character.isLowerCase(first)){
            while(i < len){
                if(Character.isUpperCase(word.charAt(i))){
                    return false;
                }
                i++;
            }
        }else{ //upper case
            if(len == 1) return true;
            char second = word.charAt(1);
            boolean temp = Character.isUpperCase(second);
            i = 1;
            while(i < len){
                if(Character.isUpperCase(word.charAt(i))!=temp){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
