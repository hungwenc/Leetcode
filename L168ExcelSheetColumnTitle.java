/*L168 Excel Sheet Column Title
Given a positive integer, return its corresponding column title as appear in an Excel sheet.
For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/
class Solution {
    public String convertToTitle(int n) {
        if(n <= 0) return null;
        StringBuilder sb = new StringBuilder();
        char c = '0';
        while(n > 0){
            if(n % 26 == 0){
                sb.append("Z");
                n = n - 26;
            }else{
                c = (char)((n - 1) % 26 + 'A');
                sb.append(c);
                n = n - n % 26;
            } 
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}
