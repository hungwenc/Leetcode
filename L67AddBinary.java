/*L67. Add Binary
Given two binary strings, return their sum (also a binary string).
For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i >= 0 && j >= 0){
            int av = (a.charAt(i) == '0') ? 0 : 1;
            int bv = (b.charAt(j) == '0') ? 0 : 1;
            int value = av + bv + carry;
            carry = value / 2;
            sb.append(value % 2);
            i--;
            j--;
        }
        
        while(i >= 0){ // if i still >= 0 but j < 0
            int av = (a.charAt(i) == '0') ? 0 : 1;
            int value = av + carry;
            carry = value / 2;
            sb.append(value % 2);
            i--;
        }
        
        while(j >= 0){ // if j still >= 0 but i < 0
            int bv = (b.charAt(j) == '0') ? 0 : 1;
            int value = bv + carry;
            carry = value / 2;
            sb.append(value % 2);
            j--;
        }
        
        if(carry == 1){
            sb.append("1");
        }
        
        return sb.reverse().toString();
    }
}
