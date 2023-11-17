package Copilot.MergeSort.T48;

public class MergeSort {
    public void mergeSort(int[] array) {
        // check if the array is null or empty
        if (array == null || array.length == 0) {
            return;
        }
        // call mergeSortHelper method
        mergeSortHelper(array, 0, array.length - 1);
    }
    private void mergeSortHelper(int[] array, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }
        // recursive rules
        int mid = left + (right - left) / 2;
        // sort left half
        mergeSortHelper(array, left, mid);
        // sort right half
        mergeSortHelper(array, mid + 1, right);
        // merge two halves
        merge(array, left, mid, right);
    }
    private void merge(int[] array, int left, int mid, int right) {
        // create a temporary array to store the sorted array
        int[] temp = new int[right - left + 1];
        // create two pointers to indicate the current position of left half and right half
        int leftIndex = left;
        int rightIndex = mid + 1;
        // create a pointer to indicate the current position of temp array
        int index = 0;
        // compare the value of left half and right half, then put the smaller one into temp array
        while (leftIndex <= mid && rightIndex <= right) {
            if (array[leftIndex] <= array[rightIndex]) {
                temp[index++] = array[leftIndex++];
            } else {
                temp[index++] = array[rightIndex++];
            }
        }
        // if there are some elements left in the left half, put them into temp array
        while (leftIndex <= mid) {
            temp[index++] = array[leftIndex++];
        }
        // if there are some elements left in the right half, put them into temp array
        while (rightIndex <= right) {
            temp[index++] = array[rightIndex++];
        }
        // copy the sorted array from temp array to original array
        for (int i = 0; i < temp.length; i++) {
            array[left + i] = temp[i];
        }
    }
}
