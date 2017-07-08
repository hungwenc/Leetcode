/*L461. Hamming Distance
The Hamming distance between two integers is 
the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
Note:
0 ≤ x, y < 231.
Example:
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ?   ?
The above arrows point to positions where the corresponding bits are different.
*/
public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y; //XOR: if same => 0, if diff => 1
        int ans = 0;
        while(xor!=0){
            // extract the Least Significant Bit(LSB)
            // ex. 1 0 0 0 0 0 1 0 1 
            //                     ^ extract this one
            int one = xor & 1;   
            if(one == 1) ans++;
            xor = xor >> 1; // divide by 2;
        }
        return ans;
    }
}
