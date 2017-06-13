/*L77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
For example,
If n = 4 and k = 2, a solution is:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
// time O(n!)
// space O(n)
public class Solution {
    public List<List<Integer>> combine(int n, int k) { // select k from 1-n
         List<List<Integer>> outer = new ArrayList<List<Integer>>();
         if(n <= 0 || k <= 0 || k > n) return outer;
         dfs(outer, new ArrayList<Integer>(), n, k);
         return outer;
    }
    private void dfs(List<List<Integer>> outer,  List<Integer> inner, int n, int k){
         if(inner.size() == k){
             outer.add(new ArrayList<Integer>(inner));
            return;
         }
         for(int s = 1  ; s <= n; s++){
             if(inner.size()!=0 && inner.get(inner.size()-1) >= s){
                 continue;
             }
             inner.add(s);
             dfs(outer, inner, n, k );
             inner.remove(inner.size() - 1);
         }
    }
}

/* better sol
public static List<List<Integer>> combine(int n, int k) {
	List<List<Integer>> combs = new ArrayList<List<Integer>>();
	combine(combs, new ArrayList<Integer>(), 1, n, k);
	return combs;
}
public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
	if(k==0) {
		combs.add(new ArrayList<Integer>(comb));
		return;
	}
	for(int i=start;i<=n;i++) {
		comb.add(i);
		combine(combs, comb, i+1, n, k-1);
		comb.remove(comb.size()-1);
	}
}
*/
