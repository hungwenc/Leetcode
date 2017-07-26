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
