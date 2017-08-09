/* L383. Ransom Note
Given an arbitrary ransom note string and another string containing letters from all the magazines, 
write a function that will return true if the ransom note can be constructed from the magazines ; 
otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> rmap = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++){
            if(rmap.containsKey(ransomNote.charAt(i))){
                rmap.put(ransomNote.charAt(i), rmap.get(ransomNote.charAt(i)) + 1);
            }else{
                rmap.put(ransomNote.charAt(i), 1);
            }
        }
        for(int i = 0; i < magazine.length(); i++){
            if(rmap.size() == 0) return true;
            if(rmap.containsKey(magazine.charAt(i))){
                char key = magazine.charAt(i);
                if(rmap.get(key) == 1){
                    rmap.remove(key);
                }else{
                    rmap.put(key, rmap.get(key) - 1);
                }
            }
        }
        return (rmap.size() == 0);
    }
}
