/*L69. Sqrt(x)
Implement int sqrt(int x).
Compute and return the square root of x.
*/
// use binary search
public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
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
                //Note4. key part:
                if((mid+1) > x / (mid+1) ){
                    return mid;
                }
                left = mid + 1;
            }else{
                return mid;
            }
        }
        
        //Note5. return mid? left ? or right?
        return  mid;
    }
}
