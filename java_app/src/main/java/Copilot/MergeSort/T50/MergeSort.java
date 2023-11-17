package Copilot.MergeSort.T50;

public class MergeSort {
        // MergeSort class with a mergeSort(int[]) method
        public void mergeSort(int[] arr) {
            // Base case: if array length is less than 2, return
            if (arr.length < 2) {
                return;
            }
            // Split the array into two halves
            int midIdx = arr.length / 2;
            int[] left = new int[midIdx];
            int[] right = new int[arr.length - midIdx];
            for (int i = 0; i < midIdx; i++) {
                left[i] = arr[i];
            }
            for (int i = midIdx; i < arr.length; i++) {
                right[i - midIdx] = arr[i];
            }
            // Merge sort each half
            mergeSort(left);
            mergeSort(right);
            // Merge the halves together
            merge(left, right, arr);
        }
    
        // Merge the two halves back together
        private void merge(int[] left, int[] right, int[] arr) {
            // Create pointers for each array
            int leftIdx = 0;
            int rightIdx = 0;
            int arrIdx = 0;
            // Compare the two arrays and add the smaller element to the original array
            while (leftIdx < left.length && rightIdx < right.length) {
                if (left[leftIdx] < right[rightIdx]) {
                    arr[arrIdx] = left[leftIdx];
                    leftIdx++;
                } else {
                    arr[arrIdx] = right[rightIdx];
                    rightIdx++;
                }
                arrIdx++;
            }
            // Add the remaining elements from the left array
            while (leftIdx < left.length) {
                arr[arrIdx] = left[leftIdx];
                leftIdx++;
                arrIdx++;
            }
            // Add the remaining elements from the right array
            while (rightIdx < right.length) {
                arr[arrIdx] = right[rightIdx];
                rightIdx++;
                arrIdx++;
            }
        }
}
