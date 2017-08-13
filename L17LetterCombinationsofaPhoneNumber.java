/*L17. Letter Combinations of a Phone Number
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you wa
*/

//Similar to Permutation, Combination
public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        char[] darr = digits.toCharArray(); //digits array
        if(darr == null || darr.length == 0) return res;
        helper(darr, dict, res, new ArrayList<Character>());
        return res;
    }
    private void helper(char[] darr, String[] dict, List<String> res, List<Character> path){
        if(path.size() == darr.length){
            String temp = "";
            for(int i = 0; i < path.size(); i++){
                temp = temp + path.get(i);
            }
            res.add(temp);
            return;
        }
        int pos = darr[path.size()] - '0';
        for(int i = 0; i < dict[pos].length(); i++){
            path.add(dict[pos].charAt(i));
            helper(darr, dict, res, path);
            path.remove(path.size()-1);
        }
    }
}

// better sol
// http://www.jiuzhang.com/solutions/letter-combinations-of-a-phone-number/
