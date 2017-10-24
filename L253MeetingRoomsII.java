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
Just want to share another idea that uses min heap (default priority queue is min heap), 
average time complexity is O(nlogn).
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.end - b.end; }
        });

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after 
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // don't forget to put the meeting room back
            heap.offer(interval);
        }

        return heap.size();
    }
}
*/
