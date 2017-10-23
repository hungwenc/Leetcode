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

// idea: https://www.youtube.com/watch?v=0roQnDBC27o
//sol1 sort for start and sort for end respectively, this method can also apply to follow up meeting room 2
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        int[] startArray = new int[intervals.length];
        int[] endArray = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            startArray[i] = intervals[i].start;
            endArray[i] = intervals[i].end;
        }
        Arrays.sort(startArray);
        Arrays.sort(endArray);
        for(int i = 1; i < intervals.length; i++){
            if(startArray[i] < endArray[i-1]){
                // overlap -> conflict
                return false;
            }
        }
        return true;
    }
}


//sol2 override sort
/*
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
*/
