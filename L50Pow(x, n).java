/*50. Pow(x, n)
Implement pow(x, n).
*/
// 1. recursion O(log n)
// 2. brute force O(n)
public class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(x == 1 || n == 0) return 1.0f;
        if(n == 1) return x;
        if(n < 0){
            x = 1/x;
            n = Math.abs(n);
        } 
        return helper(x, n);
    }
    private double helper(double x, int n){
        if(n == 1) return x;
        double temp = helper(x, n/2);
        if(n % 2 == 0){ // even power
            return temp*temp;
        }else{ // odd power
            return temp * temp * x;
        }
    }
}
