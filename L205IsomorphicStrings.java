import java.util.*;
/* L205. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */
//need to use two map to deal with the test case like "ab" "aa"
public class L205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        //assume both s and t have the same length.
        if(s == null || t == null) return false;
        HashMap<Character, Character> map_s = new HashMap<Character, Character>();
        HashMap<Character, Character> map_t = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++){
            if(map_s.containsKey(s.charAt(i))){
                if(map_s.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }else{
                 map_s.put(s.charAt(i), t.charAt(i));
            }
        }
        for(int i = 0; i < t.length(); i++){
            if(map_t.containsKey(t.charAt(i))){
                if(map_t.get(t.charAt(i)) != s.charAt(i)){
                    return false;
                }
            }else{
                 map_t.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }
}
