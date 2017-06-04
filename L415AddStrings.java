/* L415. Add Strings
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class L415AddStrings {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 == 0) return num2;
        if(len2 == 0) return num1;
        int i = len1-1;
        int j = len2-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >=0 || carry==1 ){
            int x = (i >= 0) ? (num1.charAt(i--) - '0') : 0;
            int y = (j >= 0) ? (num2.charAt(j--) - '0') : 0;
            sb.append((x + y + carry)%10);
            carry = (x + y + carry)/10;
        }
        return sb.reverse().toString();
    }
}
