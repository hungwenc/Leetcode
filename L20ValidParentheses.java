import java.util.*;
/* L20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class L20ValidParentheses {
    public boolean isValid(String s) {
        if(s == null) return false;
        // Stack<Character>   not stack<char>
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while(i < s.length()){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if((stack.peek() == '(' && s.charAt(i)==')' )|| (stack.peek() == '[' && s.charAt(i)==']' ) || (stack.peek() == '{' && s.charAt(i)=='}' )){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
}
