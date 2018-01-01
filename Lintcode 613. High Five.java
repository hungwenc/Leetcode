/*Lintcode 613. High Five 
There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.
Example
Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]

Return 
*/
/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> answer = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> hash = new HashMap<>();
        
        if (results == null || results.length == 0) {
            return answer;
        }
        
        for (Record r : results) {
            if (!hash.containsKey(r.id)){
                hash.put(r.id, new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> pq = hash.get(r.id); // score pq
            if (pq.size() < 5) {
                pq.add(r.score);
            } else {
                if (pq.peek() < r.score){ // pq裡面最小的 和目前score比較
                    pq.poll();
                    pq.add(r.score);
                }
            }
        }
        
        // iterate map
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : hash.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            double average = 0.0;
            int size = scores.size();
            while (scores.size() > 0) {
                average += scores.poll();
            }
            average /= size;
            answer.put(id, average);
        }
        return answer;
    }
}
