/*L138. Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

//sol1 optimize space without HashMap
// Time:  O(n)
// Space: O(1)
// idea:https://www.youtube.com/watch?v=-ExVoZXedo4
//1. insert copy nodes: 1 -> 1' -> 2 -> 2' -> 3 -> 3'
//2. copy random pointer
//3. seperate into two lists
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
            
        // Step1. insert node
        // 1 -> 1' -> 2 -> 2' -> 3 -> 3'
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        
        // Step2. copy random pointer
        cur = head;
        while(cur != null){
            RandomListNode temp = cur.next;
            if(cur.random != null){ // 題目有說 他可能指向null!! 所以要判斷 不然cur.random.next 會有問題
                temp.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        // Step3. split into two lists
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode temp = dummy;
        cur = head;
        while(cur != null){
           temp.next = cur.next;
           cur.next = cur.next.next;
           cur = cur.next;
           temp = temp.next;
        }
        return dummy.next;
    }
}
/*Lintcode寫法
//想清楚null的edge case 很常有問題就是 "null.next"
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);        
    }
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    private void copyRandom(RandomListNode head) {
        while (head != null) {
            // random pointer could point to any node in the list or null
            // 如果head.random == null 之後再寫 .next會出問題
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    private RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode newCurt = head.next;
            head.next = newCurt.next;
            if (newCurt.next != null) { //記得要寫這個判斷
                newCurt.next = newCurt.next.next;
            }
            head = head.next;
        }
        return newHead;
    }
}
*/

//sol2 HashMap
// Time:  O(n)
// Space: O(n)
/*
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        if(head == null) return null;
        
        // create new list
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newNode = null;
        
        while(head != null){
            if(map.containsKey(head)){
                newNode = map.get(head);
            }else{
                newNode = new RandomListNode(head.label);
                map.put(head, newNode); // copy new node
            }
            pre.next = newNode;
            if(head.random != null){
                if(map.containsKey(head.random)){
                    newNode.random = map.get(head.random); 
                }else{
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            pre = newNode;
            head = head.next;
        }
        return dummy.next;
    }
}
*/
