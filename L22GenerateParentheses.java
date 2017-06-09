/*L22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper(res, "", 0, 0, n);
        return res;
    }
    // left    (
    // right   )
    public void helper(List<String> res, String str, int left, int right, int n){
        if(right == n){ // base case
            res.add(str);
            return;
        } 
        if(left < n){
            helper(res, str + "(", left + 1, right, n);
        }
        
        if(left > right){
            helper(res, str + ")", left, right + 1, n);
        }
    }
}
