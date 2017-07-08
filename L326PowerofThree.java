/*L326. Power of Three
Given an integer, write a function to determine if it is a power of three.
Follow up:
Could you do it without using any loop / recursion?
*/
//http://blog.csdn.net/ebowtang/article/details/50485622
// sol1
public class Solution {
    public boolean isPowerOfThree(int n) {
        int maxPowerOfThree = 1162261467;
        return (n > 0) && (maxPowerOfThree % n == 0);
    }
}

// sol2 recursive
/*
public class Solution {
    public boolean isPowerOfThree(int n) {
        while(n>0 && n%3==0){
            n = n / 3;
        }
        return n==1;
    }
}
*/
