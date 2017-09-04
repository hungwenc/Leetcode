/*L119. Pascal's Triangle II
Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1].
Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

// Time:  O(n^2)
// Space: O(1)

//從後面往前算 如此可以節省空間 概念類似dp
/*
1          k = 0
1 1        k = 1
1 2 1      k = 2
1 3 3 1    k = 3
1 4 6 4 1  k = 4
*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0) return res;
        
        res.add(1);
        int k; // row
        int j; // column
        for(k = 1; k <= rowIndex; k++){
            for(j = k-1; j >= 1; j--){
                res.set(j, res.get(j-1) + res.get(j));
            }   
            res.add(1); // add the last element '1'
        }
        return res;
    }
}
