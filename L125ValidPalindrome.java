/*L125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
*/
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length()==0) return true;
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            char head = s.charAt(i);
            char tail = s.charAt(j);
            if(Character.isLetterOrDigit(head) && Character.isLetterOrDigit(tail)){
                if(head != tail) return false;
                i++;
                j--;
            }
            if(!Character.isLetterOrDigit(head)){
                i++;
            }
            if(!Character.isLetterOrDigit(tail)){
                j--;
            }
        }
        return true;
    }
}
