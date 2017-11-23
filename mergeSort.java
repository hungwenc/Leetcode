// mergeSort version 
public class Solution {
    public void sortIntegers(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }
    //use divide and conquer concept
    private void mergeSort(int[] A, int start, int end, int[] temp) {
        //遞歸的出口 -- 何時終止recursion
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        //divide into two part and sort respectively
        mergeSort(A, start, mid, temp);
        mergeSort(A, mid + 1, end, temp);
        //merge two part
        merge(A, start, end, temp);
    }
    private void merge(int[] A, int start, int end, int[] temp) {
        // if (start >= end) return;
        int mid = start + (end - start) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = start;
        while (leftIndex <= mid && rightIndex <= end) {
            if (A[leftIndex] <= A[rightIndex]) {
                temp[index] = A[leftIndex];
                index++;
                leftIndex++;
            }else {
                temp[index] = A[rightIndex];
                index++;
                rightIndex++;
            }
        }
        while (leftIndex <= mid) {
            temp[index] = A[leftIndex];
            index++;
            leftIndex++;
        }
        while (rightIndex <= end) {
            temp[index] = A[rightIndex];
            index++;
            rightIndex++;
        }
        //把輔助的array上的element 複製回原來的array
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
        return;
    }
}
