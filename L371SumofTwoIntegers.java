/*L371. Sum of Two Integers
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
Example:
Given a = 1 and b = 2, return 3.
*/
//bit trick //難
//https://skyyen999.gitbooks.io/-leetcode-with-javascript/content/questions/371md.html
public class Solution {
    public int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        while( b != 0){
            int carry = (a & b); // 進位的
            a = a ^ b;           // 沒進位的
            b = carry << 1; 
        }
        return a;
    }
}
