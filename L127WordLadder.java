/*L127. Word Ladder
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/
// Time:  O(n * d), n is length of string, d is size of wordList
// Space: O(list size)
// use BFS (for shortest path purpose)
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++){
            dict.add(wordList.get(i));
        }
       
        Queue<String> q = new LinkedList<String>(); // queue can't be implemneted by ArrayList
        Set<String> visited = new HashSet<>(); 
        
        int level = 1;
        if(beginWord.equals(endWord)) return level;
        
        q.offer(beginWord);
        visited.add(beginWord);
            
        while(!q.isEmpty()){
            level++; // next level
            int size = q.size(); // this level's size
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                ArrayList<String> nextWords = getNext(word, dict);
                for(String nextWord: nextWords){
                    if(visited.contains(nextWord)){
                        continue;
                    }
                    
                    if(nextWord.equals(endWord)){
                        return level;
                    }else{
                        q.offer(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
        }
        return 0;
    }
    
    private ArrayList<String> getNext(String word, Set<String> dict){
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for(int i = 0; i < word.length(); i++){
                if(ch == word.charAt(i)){
                    continue;
                }
                String temp = replace(word, i, ch);
                if(dict.contains(temp)){
                    nextWords.add(temp);
                }
            }    
        }
        return nextWords;
    }
    
    private String replace(String word, int index, char ch){ // replace only one character
        char[] arr = word.toCharArray();
        arr[index] = ch;
        return new String(arr);
    }
}
