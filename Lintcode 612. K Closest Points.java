/*Lintcode 612. K Closest Points (Amazon, Linkedin)
Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.

Example
Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
return [[1,1],[2,5],[4,4]]
思考 要用minHeap 還是 maxHeap來解呢?
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
// 假設 n個點
// maxHeap -> time:nlogk, 最佳解應該是用quick select的O(n)解法
public class Solution {
    public Point globalOrigin = null;
    public Comparator<Point> pointComparator = new Comparator<Point>() {
        public int compare(Point p1, Point p2) {
            int MINHEAPTOMAXHEAP = -1;// 乘這個數表示把原來的minHeap變成maxHeap
            double d1 = getDistance(p1, globalOrigin);
            double d2 = getDistance(p2, globalOrigin);
            // if return '-' => p1, p2 小到大
            // if return '+' => p2, p1 大到小
            if (d1 == d2) {
                if (p1.x != p2.x){
                    return (p1.x - p2.x)*MINHEAPTOMAXHEAP;
                }
                return (p1.y - p2.y)*MINHEAPTOMAXHEAP;
            } else if (d1 < d2){
                return -1 * MINHEAPTOMAXHEAP;
            } 
            return +1 * MINHEAPTOMAXHEAP; // else d1 > d2
        }    
    };
    
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // validate input
        if (points == null || points.length == 0) {
            return null;
        }
        if (k <= 0) {
            return new Point[0]; 
        }
        
        globalOrigin = origin;
        // 維持size = k的 heap 滿了就把最大的從heap poll出來 保留較小的k個在heap裡面 注意不是min-heap
        Queue<Point> maxHeap = new PriorityQueue<Point>(k, pointComparator); 
        Point[] result = new Point[k];
        for (int i = 0; i < points.length; i++) { // time O(n次logk)
            maxHeap.offer(points[i]);  // logK
            if (maxHeap.size() > k){
                maxHeap.poll(); // logK
            }
        }
        while (!maxHeap.isEmpty()) { // time O(k)
            result[--k] = maxHeap.poll(); // 從array尾巴放
        }
        return result;
    }
    public double getDistance(Point p, Point o) {
        return (p.x - o.x)*(p.x - o.x) + (p.y - o.y)*(p.y - o.y); 
    }
}
