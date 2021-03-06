/*L507. Perfect Number
We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)
*/

public class Solution {
    public boolean checkPerfectNumber(int num) {
        // if num==1 return false
        if(num <= 1 || num > 1e8) return false;
        int sum = 0;
        int i = 2; // start it from 2
        while(i*i <= num){
            if(num % i == 0){
                sum = sum + i;
                sum = sum + (num/i);
            }
            i++;
        }
        // be careful
        sum = sum + 1; // becasue it can be divied by 1;
        return (sum == num);
    }
}
