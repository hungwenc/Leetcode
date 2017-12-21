/*L126. Word Ladder II
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/
//sol:難
//step1 End -> Start using BFS 同時計算smallest distance from each node to End node 
//step2 Start -> End using DFS 
//注意leetcode的測資和Lintcode不同 
//Leetcode endWord 不在wordList裡面 且是用List<String> wordList
//Lintcode 是用Set<String> dict
//good ref: http://www.jiuzhang.com/solution/word-ladder-ii/
public class Solution {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        List<List<String>> ladders = new ArrayList<List<String>>();//result
        Map<String, List<String>> map = new HashMap<String, List<String>>();//找鄰居
        Map<String, Integer> distance = new HashMap<String, Integer>(); //每個node到end的最短距離

        dict.add(start);
        if (!dict.contains(end)) {
            return ladders;
        }
        // dict.add(end);
        // End -> Start use BFS (同時計算smallest distance from each node to End)
        bfs(map, distance, end, start, dict);
        
        List<String> path = new ArrayList<String>();//組成result的each path
        // Start -> End use DFS (with reverse)
        dfs(ladders, path, start, end, distance, map);

        return ladders;
    }

    void dfs(List<List<String>> ladders, 
             List<String> path, 
             String crt,
             String end, 
             Map<String, Integer> distance,
             Map<String, List<String>> map) {
        path.add(crt);
        if (crt.equals(end)) {
            ladders.add(new ArrayList<String>(path));
        } else {
            for (String next : map.get(crt)) {
                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) { 
                    dfs(ladders, path, next, end, distance, map);
                }
            }           
        }
        path.remove(path.size() - 1); //dfs用完backtrack
    }

    void bfs(Map<String, 
             List<String>> map, 
             Map<String, Integer> distance,
             String end, 
             String start, 
             Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(end);
        distance.put(end, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        while (!q.isEmpty()) {
            String crt = q.poll();
            List<String> nextList = getNextWords(crt, dict);
            for (String next : nextList) {
                map.get(next).add(crt);
                // 利用distance.containsKey來去重
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt) + 1);
                    q.offer(next);
                }
            }
        }
    }
    //word ladder I 用的難點
    private List<String> getNextWords(String head, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < head.length(); i++) {
                if (c == head.charAt(i)){
                    continue;
                }
                String nextWord = replace(head, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    
    private String replace(String s, int index, char c) {
        char[] charArray = s.toCharArray();
        charArray[index] = c;
        return new String(charArray);
    }
}
