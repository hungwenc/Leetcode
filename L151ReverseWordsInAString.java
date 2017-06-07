/*L151. Reverse Words in a String
Given an input string, reverse the string word by word.
For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.

Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.

How about multiple spaces between two words?
Reduce them to a 'single space' in the reversed string.
*/
public class Solution {
    public String reverseWords(String s) {
        if(s==null) return null;
        
        // deal with leading and trailing whitespace
        s = s.trim();
        
        String[] s_arr = s.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for(String t:s_arr){    
            System.out.println(t);
        }
        for(int i = s_arr.length-1 ; i>=0; i--){
            sb.append(s_arr[i]);
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

/*
split
如果字串中有多個分隔符號時，就須加上"|"。
String str = "aaa:bbb-ccc_ddd";
String[] tokens = str.split(":|-|_");

當delimiter用到特殊字元時，如".", "|", "$"，此時要在特殊字元前面加上"\\"，才會得到正確的結果。
String str = "aaa-bbb-ccc.ddd";
String[] tokens = str.split("-|\\.");
for (String token:tokens) {
    System.out.println(token);
}

*處理第一個character split會產生多餘的 空白
https://stackoverflow.com/questions/9389503/how-to-prevent-java-lang-string-split-from-creating-a-leading-empty-string

trim去空白
trim()可以去除左邊及右邊二則空白，不過在字串間空白並不會處理


replace
x = x.replaceAll("\\s", "");
x = x.replaceAll("\\s+", "");
\\s - matches single whitespace character
\\s+ - matches sequence of one or more whitespace characters.

String.valueOf 基本型態轉換成字串
利用靜態函數String.valueOf(型態)可以把型能轉變成字串
int num = 123;
String Snum = String.valueOf(num);

基本型態物件.parse基本型態  字串轉換成基本型態
利用基本型態物件的函數parse，可以把字轉換成基本型態，如果無法轉換時會有Exception產生
String Sint = "123";
int myint = Integer.parseInt(Sint);

IndexOf 查詢字元位存在於字串內位置,以0為起始
IndexOf(字串)，有找到字串時會回傳第一個字元的位置，IndexOf如查詢不到，則會回傳-1
字串內的內容存放可視為一連續空間，而每一個字元均存放在順序的位置上，如下表所示：
*/
