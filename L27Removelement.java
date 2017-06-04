/*L27. Remove Element
Given an array and a value, remove all instances of that value in place and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
Example:
Given input array nums = [3,2,2,3], val = 3
Your function should return length = 2, with the first two elements of nums being 2.
*/
public class L27Removelement {
    public int removeElement(int[] A, int elem) {
        // write your code here
        int len = A.length;
        int i = 0;
        int j = len - 1;
        int temp = 0;
        while(i <= j){
            if((A[i] == elem) && (A[j] != elem)){
                //exchange
                A[i] = A[j];
                A[j] = elem;
                i++;
                j--;
            }else if (A[i] != elem){
                // let i move forward
                i++;
            }else if (A[j] == elem){
                // let j move backward
                j--;
            }
        }
        return i;
    }
}
