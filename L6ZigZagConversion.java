/*L6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() <= 1 ||numRows <= 1) return s;
        int len = s.length();
        char[] carray = s.toCharArray();
        int i = 0;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        i = 0;
        while(i < len){
            for(int row_idx = 0; row_idx < numRows && i < len; row_idx++){
                sb[row_idx].append(carray[i]);
                i++;
            }
            // be careful here, its upper and lower bound in for loop
            for(int row_idx = numRows-2; row_idx >=1 && i < len; row_idx--){
                sb[row_idx].append(carray[i]);
                i++;
            }
        }
        for(i = 1; i < numRows; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
