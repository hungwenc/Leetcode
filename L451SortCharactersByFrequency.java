/*L451. Sort Characters By Frequency
Given a string, sort it in decreasing order based on the frequency of characters.
Example 1:
Input:
"tree"
Output:
"eert"
Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
*/

public class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        char[] c_array = s.toCharArray();
        // sort the character array first, then it will be much easier to put into the hash map
        Arrays.sort(c_array);
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(i = 0; i < c_array.length; i++){
            if(map.containsKey(c_array[i])){
                map.put(c_array[i], map.get(c_array[i]) + 1);
            }else{
                map.put(c_array[i], 1);
            }
        }
        
        i = 0;
        // freq array to store the frequency numbers
        int[] freq = new int[map.size()];
        for(Integer value: map.values()){
            freq[i++] = value;
        }
        
        // sort the frequency numbers
        Arrays.sort(freq);
        char key = 'a';
        for(i = freq.length - 1; i >= 0; i--){
            int temp = freq[i];
            // get the 'key' from the hash map based on the value we have
            for(Character k_map: map.keySet()){
                if(map.get(k_map) == temp){
                    key = k_map;
                    map.remove(key);
                    break;
                }
            }
            for(j = 0; j < temp; j++){
                sb.append(key);
            }
        }
        return sb.toString(); 
    }
}
