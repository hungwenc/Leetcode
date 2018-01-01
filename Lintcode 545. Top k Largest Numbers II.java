/*Lintcode 545. Top k Largest Numbers II  (常考)
Implement a data structure, provide two interfaces:

add(number). Add a new number in the data structure.
topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.
Example
s = new Solution(3);
>> create a new data structure.
s.add(3)
s.add(10)
s.topk()
>> return [10, 3]
s.add(1000)
s.add(-99)
s.topk()
>> return [1000, 10, 3]
s.add(4)
s.topk()
>> return [1000, 10, 4]
s.add(100)
s.topk()
>> return [1000, 100, 10]


注意 此題要用min heap 而不是用max heap來做
min heap
- add  : time O(logk)
- top K: time O(klogk)

max heap
- add  : time O(logk)
- top K: time O(klogN)
*/
public class Solution {
    Queue<Integer> minHeap;
    int k;
    /*
    * @param k: An integer
    */public Solution(int k) {
        // do intialization if necessary
        minHeap = new PriorityQueue<>();
        this.k = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) { // time O(log k)
        if (minHeap.size() < k) {
            minHeap.add(num); 
        } else {
            if (num > minHeap.peek()){
                minHeap.poll(); // remove smallest
                minHeap.add(num);
            }
        }
    }

    /*
     * @return: Top k largest elements
     */
    public List<Integer> topk() { // time O(k logk) -> k次 minHeap.poll()
        List<Integer> result = new ArrayList<>();
        Iterator it = minHeap.iterator();
        while (it.hasNext()) { // iterator拿出來的沒有保證任何順序
            int temp = (int)it.next(); //拿出來後要轉型
            result.add(temp);
        }
        // 因為return 要 從大到小的sorted 
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}
