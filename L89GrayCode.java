/*L89. Gray Code
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, 
print the sequence of gray code. A gray code sequence must begin with 0.
For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/
//idea - Mirror Method: https://en.wikipedia.org/wiki/Gray_code
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n <= 1){
            for(int i = 0; i <= n; i++){
                res.add(i);
            }
            return res;
        }
        // gray(n) =  [gray(n-1)] append [reverse gray (n-1) + 1 in the Most Significant Bit]
        res = grayCode(n-1);
        int MSB = 1;
        MSB = MSB << (n-1); //left shift to get MSB
        // add MSB and append it
        for(int i = res.size()-1 ; i >= 0; i--){
            res.add(res.get(i) + MSB);
        }
        return res;
    }
}


// this version always gets Time Limit Exceeded (TLE)
/*
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n <= 1){
            for(int i = 0; i <= n; i++){
                res.add(i);
            }
            return res;
        }
        // gray(n) =  [gray(n-1)] append [reverse gray (n-1) + 1 in the Most Significant Bit]
        res = grayCode(n-1);
        List<Integer> mirror = reverse(res);
        int MSB = 1;
        MSB = MSB << (n-1); //left shift to get MSB
        // add MSB
        for(int i = 0 ; i < mirror.size(); i++){
            mirror.set(i, mirror.get(i) + MSB);
            res.add(mirror.get(i));
        }
        res.addAll(mirror);
        return res;
    }
    public List<Integer> reverse(List<Integer> list) {
        // "Collections". reverse takes a mutable list and reverses its order. 
        // It takes linear time.
        Collections.reverse(list);
        return list;
    }

}
*/
