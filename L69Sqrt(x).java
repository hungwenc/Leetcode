/*L69. Sqrt(x)
Implement int sqrt(int x).
Compute and return the square root of x.
*/
// https://www.youtube.com/watch?v=JtZBs9Qy_6M
// sol1 use binary search
// time O(logn)
// space O(1)
public class Solution {
    public int mySqrt(int x) {
        if(x <=  0) return x;
        int mid = 0;
        int left = 1;
        // we can optimize that from the below fact
        //Note1.  any nonnegative number x, its sqrt(x) won't be bigger than (x/2 + 1)
        int right = (x/2 + 1);
        while(left <= right){
            mid = left + (right - left)/2; //Note2. use divide to avoid overflow  : avoid (left+right)/2
            if(mid > x/mid){ //Note3. mid*mid > x we use divide to avoid overflow
                right = mid - 1;
            }else if (mid < x/mid){ // mid*mid < x we use divide to avoid overflow
                left = mid + 1;
            }else{
                return mid;
            }
        }
        
        //Note5. return mid? left ? or right?
        //因為等while loop 跳出的時候 right 會在 left 左邊  而sqrt本身就是要取floor的  所以選左邊的那個 right 才會最接近
        return  right;
    }
}

//sol2 use enumeration
/*
public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        long i;
        for(i = 1; i <= x; i++){
            if(valid(x, i)) break;
        }   
        return  (int)(i);
    }
    public boolean valid(int x, long y){
        if(y*y <= x && (y+1)*(y+1) > x) return true;
        return false;
    }
}
*/
