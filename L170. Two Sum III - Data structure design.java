/*L170. Two Sum III - Data structure design
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/
// 數據流的問題 data 會real time 進來
// 無法再一開始就獲得全部的data 所以沒辦法用two pointer 之類的方式處理
public class TwoSum {
    private List<Integer> list = null;
    private Map<Integer, Integer> map = null;
    
    /** Initialize your data structure here.  constructor */
    public TwoSum() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>(); // Key: number, value: count of this number
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            list.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int num1 = list.get(i);
            int num2 = value - num1;
            // ex. corner: value = 6, num1 = 3 且我們有兩個3 -> true
            if (num1 == num2) {
                if (map.get(num1) >= 2) {
                    return true;
                }
            } else { // num1 != num2
                if (map.containsKey(num2)) {
                    return true;
                }
                // else keep finding 
            }
        }
        return false;
    }
}
/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
