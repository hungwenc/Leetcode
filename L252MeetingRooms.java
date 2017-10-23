/*L252. Meeting Rooms
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
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
// Time:  O(nlogn)
// Space: O(n)
// Comparator https://openhome.cc/Gossip/Java/ComparableComparator.html
// java sort for primitive : will use quicksort
// java sort for object    : will use mergesort 
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            // override
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i].end > intervals[i+1].start){
                // overlap -> conflict
                return false;
            }
        }
        return true;
    }
}
