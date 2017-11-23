// quickSort version 
public class Solution {
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }
    private void quickSort(int[] A, int start, int end) {
        if (start >= end){ // 當start == end時就不需要排了呀 因為只有一個數 有什麼好排?
            return;
        }
        int left = start;
        int right = end;
        //1. get pivot 'value' not 'index' of array
        int pivot = A[left + (right - left) / 2];
        //2. 注意left 和 right比較時要加等號
        //3. 注意和pivot做比較時 不要加等號
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            } 
            // leave while loop when right hind side have value smaller or equal to pivot
            //等於pivot的情況也要做交換 才能均勻分配在pivot兩側
            if (left <= right) { //swap
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        // leave while loop時 會滿足left > right
        // 所以交錯 right目前在左邊, left在右邊
        //                  V--right
        // ex. 3 2 1 4 5 => 1 2 3 4 5
        //                    ^--left
        //4. 注意這編寫的參數
        quickSort(A, start, right);//對左半部做QS
        quickSort(A, left, end);//對右半部做QS
    }
}
/*很可能面試要你實作Quicksort partition
分割(Partition)：將數列依基準值分成三部份(快速排序作法中，第2,3步驟)
左子數列：比基準值小的數值
中子數列：基準值
右子數列：比基準值大的數值
*/
