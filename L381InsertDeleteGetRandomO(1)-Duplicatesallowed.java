/*L381. Insert Delete GetRandom O(1) - Duplicates allowed
Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
*/
// replacing HashSet with LinkedHashSet because the set.iterator() might be costly when a number has too many duplicates. Using LinkedHashSet can be considered as O(1) if we only get the first element to remove.
public class RandomizedCollection {
    ArrayList<Integer> list; // <value>
    Map<Integer, LinkedHashSet<Integer>> map; // <value, collections of locations>
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<Integer>();
        map  = new HashMap<>();
    }
    
    /** Inserts a value to the collection. 
    Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if(!contain){
            map.put(val, new LinkedHashSet<Integer>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if(!contain) return false;
        
        LinkedHashSet<Integer> targetSet = map.get(val);
        int targetLocation = targetSet.iterator().next();
        int lastElement = list.get(list.size()-1);
        LinkedHashSet<Integer> lastSet = map.get(lastElement);
       
        list.set(targetLocation, lastElement);        
        targetSet.remove(targetLocation);
        
        if(targetLocation != list.size()-1){
            lastSet.remove(list.size()-1);
            lastSet.add(targetLocation);
        }
        
        list.remove(list.size()-1);
        if(map.get(val).size() == 0) map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random rand = new Random();
        int randNum = rand.nextInt(list.size()); 
        return list.get(randNum);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


// 原本用ArrayList寫的 錯的 
/**
public class RandomizedCollection {
    ArrayList<Integer> list; // <value>
    Map<Integer, ArrayList<Integer>> map; // <value, collections of locations>
    public RandomizedCollection() {
        list = new ArrayList<Integer>();
        map  = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if(!contain){
            map.put(val, new ArrayList<Integer>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }
    
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if(!contain) return false;
        
        ArrayList<Integer> targetList = map.get(val);
        int targetLocation = targetList.get(targetList.size()-1); // last one element's location in the collections
        
        int lastElement = list.get(list.size()-1);
        ArrayList<Integer> lastList = map.get(lastElement);
        
       
        list.set(targetLocation, lastElement);
        
        targetList.remove(targetList.size()-1);
        
        if(targetLocation != list.size()-1){
            lastList.remove(lastList.size()-1);
            lastList.add(targetLocation);
        }
        
        list.remove(list.size()-1);
        if(map.get(val).size() == 0) map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int randNum = rand.nextInt(list.size()); 
        return list.get(randNum);
    }
}
*/
