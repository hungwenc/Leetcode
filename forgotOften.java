private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
    public int compare(ListNode l1, ListNode l2) {
        return l1.val - l2.val;
    }
};
Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator); // pq容量 跟 comparator

for (Map.Entry<Integer, PriorityQueue<Integer>> entry : hash.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
}
map.put(~~)
String.valueOf(boolean b) : 將 boolean 變數 b 轉換成字串
String.valueOf(char c) : 將 char 變數 c 轉換成字串
String.valueOf(char[] data) : 將 char 陣列 data 轉換成字串
String.valueOf(char[] data, int offset, int count) :


public static void printMap(Map mp) {
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }
}


If you're only interested in the keys, you can iterate through the keySet() of the map:

Map<String, Object> map = ...;

for (String key : map.keySet()) {
    // ...
}
If you only need the values, use values():

for (Object value : map.values()) {
    // ...
}
Finally, if you want both the key and value, use entrySet():

for (Map.Entry<String, Object> entry : map.entrySet()) {
    String key = entry.getKey();
    Object value = entry.getValue();
    // ...
}


// iterator
public List<Integer> topk() {
    Iterator it = minheap.iterator();
    List<Integer> result = new ArrayList<Integer>();
    while (it.hasNext()) {
        result.add((Integer) it.next());
    }
    Collections.sort(result, Collections.reverseOrder());
    return result;
}
