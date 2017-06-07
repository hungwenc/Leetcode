/*L14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
if only one string "a" then return "a" 
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        
        //corner case
        if(strs == null || len == 0) return "";
        if(len == 1) return strs[0];
        
        StringBuilder sb = new StringBuilder();
        String temp = strs[0];
        int i = 0; // character index 
        int j = 0; // which string
        
        while(i < temp.length()){
            j = 0;
            while(j < len){
                // notice: compare index-> (strs[j].length()-1) < i
                if(strs[j] == null || (strs[j].length()-1) < i){
                    return sb.toString();
                }
                if(strs[j].charAt(i) != temp.charAt(i)){
                    return sb.toString();
                }
                j++;
            }
            sb.append(temp.charAt(i));
            i++;
        }
        return sb.toString();
    }
}

/*website: http://69.65.10.231/~q3i1cbaf/java/007/002.htm
int indexOf(String str)
傳回 this 字串中所指定子字串 str 所在的位置。如找不到，則傳回 -1。
"Hello".indexOf("He") => 0
"Hello".indexOf("lo") => 3
"Hello".indexOf("he") => -1
*/

/* better sol
public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0)    return "";
    String pre = strs[0];
    int i = 1;
    while(i < strs.length){
        while(strs[i].indexOf(pre) != 0){ //not prefix
            pre = pre.substring(0,pre.length()-1); // 縮短目前這個string, 直到比對找到
        }
        i++;
    }
    return pre;
}
*/
