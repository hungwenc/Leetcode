/* L380. Insert Delete GetRandom O(1)
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. 
Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();

// Time:  O(1)
// Space: O(n)
*/
public class RandomizedSet {
	ArrayList<Integer> list; // put value 
	Map<Integer, Integer> map; // put <value, location>
    /** Initialize your data structure here. */
    public RandomizedSet() {
    	list = new ArrayList<>();
    	map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	boolean contain = map.containsKey(val);
    	if(contain == true){
    		return false;
    	}
    	// contain == false, then insert it
    	map.put(val, list.size());
    	list.add(val);
    	return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	boolean contain = map.containsKey(val);
    	if(contain == false){
    		return false;
    	}
    	// remove the value
    	int index = map.get(val); // get this value's index in ArrayList 
    	int last = list.size()-1; // index of last element in ArrayList 
    	if(index != last){
    		//swap value
    		// ArrayList.set(int index, E element)
    		list.set(index, list.get(last));
    		// remember to update the <value, location> pair in the map
    		map.put(list.get(last), index);
    	}
    	map.remove(val);
    	list.remove(list.size()-1); // remove last element 
    	return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
		Random rand = new Random();
		int randnum = rand.nextInt(map.size()); // rand.nextInt(n); -> return value from 0 <= x < n
		return list.get(randnum);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */