/*L66. Plus One
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len - 1;
        while( i >= 0){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{ // some digit absorb this 1, after adding 1 then we can directly return the value 
                digits[i] = digits[i] + 1;
                return digits;
            }
            i--;
        }
        int[] new_dig = new int[len + 1];
        new_dig[0] = 1;
        return new_dig;
    }
}

/* 
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 0;
        int i =  len -1;
        while(i >= 0){
            if(i== (len -1)){
                carry = 1;
            }
            digits[i] = digits[i] + carry;
            if(digits[i] >= 10){
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
            }else{
                carry = 0;
            }
            if(i-1>=0){
                i--;
            }else{
                break;
            }
        }
        if(carry == 0 ) return digits;
        int[] new_digits = new int[len + 1]; //999 -> 1000
        new_digits[0] = 1; 
        return new_digits;
    }
}
*/
