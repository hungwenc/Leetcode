// /*L140. Word Break II
// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

// Return all such possible sentences.

// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].

// A solution is ["cats and dog", "cat sand dog"].

// UPDATE (2017/1/4):
// The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
// */
// // 用額外空間來optimize solution
// // 求所有解 就是用recursive 來解
// Time:  O(n * l^2 + n * r), l is the max length of the words, 
//                            r is the number of the results.
// Space: O(n^2)
public class Solution{
    public List<String> wordBreak(String s, List<String> wordDict){
        List<String> res = new LinkedList<>();
        HashSet<String> dict = new HashSet<>();
        HashMap<String, List<String>> used = new HashMap<>();
        for(String str: wordDict){
            dict.add(str);//dict
        }
        
        //result
        res = helper(s, dict, used);
        return res;
    }
    public List<String> helper(String s, HashSet<String> dict, HashMap<String, List<String>> used){
        // cache => optimize (dp memeory)
        if(used.containsKey(s)){ // find it before, get the past record 
            return used.get(s);
        }  
        
        if(s.length() == 0) return null;
        List<String> res = new LinkedList<>();
        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0, i); //not include end index i
            List<String> partRes = null;
            if(dict.contains(sub)){
                partRes = helper(s.substring(i), dict, used); // sub string from i to the end of the string
                if(partRes == null){
                    res.add(sub);
                }else{
                    for(String str: partRes){
                        res.add(sub + " " + str);
                    }
                }
            }
        }
        used.put(s, res);
        return res;
    }
}


//sol 2. 比較容易理解
// from leetcode discuss
// Using DFS directly will lead to TLE, so I just used HashMap to save the previous results to prune duplicated branches, as the following:
/*
public class Solution{
    public List<String> wordBreak(String s,  List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for(String str: wordDict){
            dict.add(str);//dict
        }
        for (String word : dict) {
            System.out.println(word);
        }
        return DFS(s, dict, new HashMap<String, LinkedList<String>>());
    }       

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> dict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s)) 
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();     
        if (s.length() == 0) {
            res.add("");
            return res;
        }               
        for (String word : dict) {
            if (s.startsWith(word)) {
                // System.out.println("w  :" + word);
                // System.out.println("sub :"+s.substring(word.length()));
                List<String>sublist = DFS(s.substring(word.length()), dict, map);
                for (String sub : sublist) 
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
            }
        }       
        // System.out.println("s  :" + s);
        // System.out.println("res:" + res);
        map.put(s, res);
        return res; // to sublist
    }
}
*/
