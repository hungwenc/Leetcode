/*L290. Word Pattern
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/
//variant of   205. Isomorphic Strings
// Time:  O(n)
// Space: O(c), c is unique count of pattern
// sol2 use only one map
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] parr = pattern.toCharArray();
        String[] sarr = str.split(" ");
        
        if(parr.length != sarr.length) return false;
        
        Map<Character, String> map1 = new HashMap<>();
        for(int i = 0; i < parr.length; i++){
            if(map1.containsKey(parr[i])){
                if(!map1.get(parr[i]).equals(sarr[i])){
                    return false;
                }
            }else{
                // optimize
                if(map1.containsValue(sarr[i])){
                    return false;
                }
                map1.put(parr[i], sarr[i]);
            }
        }
        return true;
    }
}

// sol1 use two maps
/*
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] parr = pattern.toCharArray();
        String[] sarr = str.split(" ");
        
        if(parr.length != sarr.length) return false;
        
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for(int i = 0; i < parr.length; i++){
            if(map1.containsKey(parr[i])){
                if(!map1.get(parr[i]).equals(sarr[i])){
                    return false;
                }
            }else{
                map1.put(parr[i], sarr[i]);
            }
            
            if(map2.containsKey(sarr[i])){
                if(!map2.get(sarr[i]).equals(parr[i])){
                    return false;
                }
            }else{
                map2.put(sarr[i], parr[i]);
            }
        }
        return true;
    }
}
*/
