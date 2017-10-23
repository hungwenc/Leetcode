/*L253. Meeting Rooms II
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
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
// idea: https://www.youtube.com/watch?v=0roQnDBC27o

//sol1 
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int[] startArray = new int[intervals.length];
        int[] endArray = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            startArray[i] = intervals[i].start;
            endArray[i] = intervals[i].end;
        }
        Arrays.sort(startArray);
        Arrays.sort(endArray);
        int endPoint = 0;
        int res = 0;
        for(int i = 0; i < intervals.length; i++){
            if(startArray[i] < endArray[endPoint]){
                res++;
            }else{
                endPoint++;
            }
        }
        return res;
    }
}

//sol2
/*
public int minMeetingRooms(Interval[] intervals) {
    if(intervals==null||intervals.length==0)
        return 0;
 
    Arrays.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
            return i1.start-i2.start;
        }
    });
 
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    int count=1;
    queue.offer(intervals[0].end);
 
    for(int i=1; i<intervals.length; i++){
        if(intervals[i].start<queue.peek()){
            count++;
 
        }else{
            queue.poll();
        }
 
        queue.offer(intervals[i].end);
    }
 
    return count;
}
*/
