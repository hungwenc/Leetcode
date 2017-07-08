/*L500. Keyboard Row
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
*/
public class Solution {
    public String[] findWords(String[] words) {
        if(words == null) return null;
        List<String> res = new LinkedList<String>();
        String[] row = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        int number = 0;
        for(int i = 0; i < words.length; i++){
            String temp = words[i].toUpperCase();
            for(int k = 0; k < row.length; k++){
                if(row[k].indexOf(temp.charAt(0)) != -1){
                    number = k; // in this row
                    break;
                }
            }
            boolean pass = true;
            for(int j = 1; j < temp.length(); j++){
                if(row[number].indexOf(temp.charAt(j)) == -1){
                    pass = false;
                    break; 
                }
            }
            if(pass == true) res.add(words[i]);
        }
        return res.toArray(new String[0]);
    }
}

// sol2 Regular Expression
/*
public String[] findWords(String[] words) {
    return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
}
*/
