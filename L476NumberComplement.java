/**
 * 476. Number Complement
 * 測資常常會有 2147483647
 * 所以我們要用long!!!
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */

public class L476NumberComplement {
    public int findComplement(int num) {
        long ans;
        int[] a = new int[2];
        if(num==1){
            return 0;
        }
        long i = 1;
        while(i <= num){
            i = i*2;
        }
        i = i - 1;
        ans = num^i;
        return (int)ans;
    }
}