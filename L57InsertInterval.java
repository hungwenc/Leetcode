/* L57. Insert Interval
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval obj1, Interval obj2){
               return obj1.start - obj2.start;
           } 
        });
        
        List<Interval> ans = new ArrayList<>();
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            ans.add(intervals.get(i));
            i++;
        }
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){ // "==" case, should merge
            newInterval = new Interval(
                Math.min(intervals.get(i).start, newInterval.start), 
                Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        ans.add(newInterval); // edge case if newInterval doesn't overlap with other intervals
        while(i < intervals.size()){
            ans.add(intervals.get(i));
            i++;
        }
        return ans;
    }
}
