/* L49. Group Anagrams

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
              char[] key = strs[i].toCharArray();
              Arrays.sort(key);
              // String skey = key.toString(); can't use??  
              String skey = String.valueOf(key);
              if(map.containsKey(skey)){
                map.get(skey).add(strs[i]);
              }else{
                List<String> inner = new ArrayList<String>();
                inner.add(strs[i]);
                map.put(skey, inner);
              }
        }

        // Iterator it = map.entrySet().iterator();
        // while(it.hasNext()){
        //   Map.Entry pair = (Map.Entry)it.next(); // casting
        //   res.add(pair.getValue());
        //   it.remove();
        // }
        
        // for(Map.Entry<String, List<String>> entry : map.entrySet()){
        //   System.out.println(entry.getValue());
        //   res.add(entry.getValue());
        // }
        
        return new ArrayList<List<String>>(map.values());
    }
}
