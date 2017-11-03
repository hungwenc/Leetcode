/**L278. First Bad Version
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); if it is bad -> return true*/

//標準的 binary search
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1 && isBadVersion(1)) return 1;
        int start = 1;
        int end = n;
        int mid = 0;
        while(start < end){
            mid = start + (end - start)/2;
            if(isBadVersion(mid) == true){ // 這個可能是 最早的 bad version 但也可能前方還有更早的bad version 所以不能排除他 要把他當成candidate
                end = mid;  // 注意 不是 end = mid - 1
            }else{ //這版是正確的 所以發生第一次bad version 在他之後 (目前這個位置已經不是我們的candidate所以排除)
                start = mid + 1;
            }
        }
        
        //跳出while loop 了 表示 start == end 且已經排除所有可能了 start 就是first bad version
        return start; 
    }
}
