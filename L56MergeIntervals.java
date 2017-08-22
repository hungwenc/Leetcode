/*L56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> input) {
        if(input == null || input.size() <= 1) return input;
        Collections.sort(input, new Comparator<Interval>(){
            public int compare(Interval obj1, Interval obj2){
                return obj1.start - obj2.start;
            }
        });
        List<Interval> ans = new ArrayList<>();
        Interval last = null;
        for(Interval item : input){
            if(last == null || last.end < item.start){
                ans.add(item);
                last = item;
            }else{ // last.end > item.start
                last.end = Math.max(last.end, item.end);
            }
        }
        return ans;
    }
}
