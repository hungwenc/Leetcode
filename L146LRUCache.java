/* L146. LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/
// double linked list + Hashtable
// HashTable put <key, pair>
// creat dummy head and tail on purpose, let the code more concise 
// 最近 有使用到 就放到linked list 的tail
// 沒被使用過的就放在head那附近   之後滿了從head端remove
//Double LinkedList: take care of the least recently used requirement, evict
//HashMap: only map takes care of the true value  

// Time:  O(1), per operation.
// Space: O(k), k is the capacity of cache.
public class LRUCache {
	// create double linked list
	private class Node{
	  int key;
	  int value;
	  Node prev;
	  Node next;
	  private Node(int key, int value){ // constructor
		 this.key = key;
		 this.value = value;
		 this.prev = null;
		 this.next = null;
	  }
	}
  
	// dummy head and tail
	Node head = new Node(-1, -1);
	Node tail = new Node(-1, -1);
  
	int capacity;
  
	// map<Key, Node>: Key & Node(Key, Value)
	private Map<Integer, Node> map = new HashMap<>();
	
	public LRUCache(int capacity) {
	  this.capacity = capacity;
	  head.next = tail;
	  tail.prev = head;
	}
	
	// head <-> least used <--------> recently used <-> tail
	private void move_to_tail(Node cur){
	  // put this Node right before the dummy Node(tail)
	  cur.next = tail;
	  cur.prev = tail.prev;

	  cur.prev.next = cur;
	  cur.next.prev = cur;
	}

	public int get(int key) {
	  if(!map.containsKey(key)){
		return -1;
	  }
	  Node cur = map.get(key); // obtain this Node from map  
	  
	  // remove cur Node position from the double linked list
	  cur.next.prev = cur.prev;
	  cur.prev.next = cur.next;

	  // update this Node position
	  move_to_tail(cur);
	  return cur.value;
	}
	
	public void put(int key, int value) {
	  // use get function to see if this node exists
	  // Notice: our get function will update the position at the same time!
	  if(get(key) != -1){ // set the value, exist in the map
	  	map.get(key).value = value;
	  	return;
	  }

	  //not exist in the map, add new node
	  if(map.size() == capacity){
	  	//size is full, we have to evict LRU node
	  	//remove this node in map (update)
	  	map.remove(head.next.key);
	  	//remove this node in double Linkedlist (update)
	  	head.next = head.next.next;
	  	head.next.prev = head;
	  }
	  Node new_node = new Node(key, value);
	  //add this node in map 
	  map.put(key, new_node);
	  //add this node in double Linkedlist 
	  move_to_tail(new_node);
	}
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*Lintcode 134. LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/
/*
首先，对于cache，如果希望有O(1)的查找复杂度，肯定要用hashmap来保存key和对象的映射。
对于LRU而言，问题在于如何用O(1)解决cache entry的替换问题。

cache的存储是一个链表的话，那么只要保证从头到尾的顺序就是cache从舊到新的顺序就好了，对于任何一个節點，如果被訪問了，那么就將該節點移至尾部。如果cache已满，那么就把頭部的删掉，从尾部插入新節點。

所以，需要用到两个数据结构

1. hashmap，保存key和对象(node)記憶體位置的映射。利用hashMap來達到O(1)的get

2. double linked list，保存對象新舊程度的序列。利用雙向linkedlist(一開始想到是queue但還需要處理拿queue
中間的元素時要怎麼移動的問題 所以使用linked list)來達成LRU的evict操作
*/
public class LRUCache {
    // 自己定義Node的class
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        private Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    /*
     * @param capacity: An integer
     */
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    
    public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node curr = map.get(key); // obtain this Node from map  
	  
	    // remove curr Node position from the double linked list
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        // update this Node position
        move_to_tail(curr);
        return curr.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // 呼叫get 函數 會順便幫我們move to tail! 在這不要用map.containsKey 
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        Node insert = new Node(key, value);
        if (map.size() == capacity) { // cache size 滿了 要 evict
            Node evict = head.next;
            map.remove(evict.key);
            head.next = evict.next;
            evict.next.prev = head;
        }
        map.put(key, insert);
        move_to_tail(insert);
        return;
    }
    
    public void move_to_tail(Node curr){
        // 把curr node 插入 tail 和 tail.prev 這兩個node中間
        // 先把curr node 和兩節點新增pointer 
        curr.prev = tail.prev;
        curr.next = tail;
        // 再把舊友的 pointer 砍斷
        curr.prev.next = curr;
        curr.next.prev = curr;
    }
}

