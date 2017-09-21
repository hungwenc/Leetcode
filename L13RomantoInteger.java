/*L13. Roman to Integer
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/
//羅馬數字:
// I 1, V 5, X 10, L 50, C 100, D 500, M 1000
// IV 4, IX 9, XL 40, XC 90, CD 400, CM 900  (扣1 or 扣10 or 扣100)

// sol: 先把全部的加完 再開始扣 (2倍)
// ex. CXLIII = 100 + 10 + 50 + 3 - (10 * 2) = 143
public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                res += 1;
            }else if(s.charAt(i) == 'V'){
                res += 5;
            }else if(s.charAt(i) == 'X'){
                res += 10;
            }else if(s.charAt(i) == 'L'){
                res += 50;
            }else if(s.charAt(i) == 'C'){
                res += 100;
            }else if(s.charAt(i) == 'D'){
                res += 500;
            }else if(s.charAt(i) == 'M'){
                res += 1000;
            }
        }
        
        // calculate the number we need to minus
        if(s.indexOf("IV") != -1) res -= (1*2); 
        if(s.indexOf("IX") != -1) res -= (1*2); 
        if(s.indexOf("XL") != -1) res -= (10*2);
        if(s.indexOf("XC") != -1) res -= (10*2);
        if(s.indexOf("CD") != -1) res -= (100*2);
        if(s.indexOf("CM") != -1) res -= (100*2);
        
        return res;
    }
}
