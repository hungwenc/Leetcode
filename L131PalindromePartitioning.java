/*L131. Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return
[
  ["aa","b"],
  ["a","a","b"]
]
*/
// sol1. DFS without preprocessing
//time O(n*2^n)
//space O(n) n = string len
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        List<String> partition = new ArrayList<>();
        helper(s, 0, partition, results);
        return results;
    }
    private void helper(String s, 
                        int startIndex, 
                        List<String> partition,
                        List<List<String>> results) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<>(partition));
        }
        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i + 1); // 因為右側參數是開區間 not include
            if (!isPalindrome(subString)) {
                continue;
            }
            partition.add(subString);
            helper(s, i + 1, partition, results);
            partition.remove(partition.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

// sol2 DFS with preprocessing - a little hard (strong yes)
//time O(2^n)
//space O(n) n = string len
/*
public class Solution {
    // global var
    List<List<String>> results;
    boolean[][] isPalindrome;

    public List<List<String>> partition(String s) {
        results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        getIsPalindrome(s);
        List<Integer> partition = new ArrayList<>();
        helper(s, 0, partition);
        return results;
    }
    private void helper(String s,
                        int startIndex,
                        List<Integer> partition) {
        if (startIndex == s.length()) {
            addResult(s, partition);
            return;
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome[startIndex][i]) {
                continue;
            }
            partition.add(i);
            helper(s, i + 1, partition);
            partition.remove(partition.size() - 1);
        }
    }
    
    private void addResult(String s, List<Integer> partition) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < partition.size(); i++) {
            result.add(s.substring(startIndex, partition.get(i) + 1));
            startIndex = partition.get(i) + 1;
        }
        results.add(result);
    }
    // 預處理 讓判斷回文變成時間複雜度O(1)
    private void getIsPalindrome(String s) {
        int n = s.length();
        isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] &&  (s.charAt(i) == s.charAt(j));
            }    
        }
    }
}
*/
