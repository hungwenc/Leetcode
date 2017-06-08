/*L202. Happy Number
Write an algorithm to determine if a number is "happy".
A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
Example: 19 is a happy number
*/

//Hashset
public class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        Set<Integer> s = new HashSet<>();
        int sum;
        while(true){
            sum = 0;
            while(n!=0){
                sum = sum + (n%10) * (n%10);
                n = n/10;
            }
            if(sum == 1){
              return true;  
            }else if(s.contains(sum)==true){ 
                return false;
            }else{
                s.add(sum);
            }
            n = sum;
        }
    }
}
