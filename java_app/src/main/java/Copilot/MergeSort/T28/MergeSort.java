package Copilot.MergeSort.T28;

public class MergeSort {
        // Merge sort algorithm
        public void mergeSort(int[] arr) {
            // Base case
            if (arr.length < 2) {
                return;
            }
            // Find the middle index
            int mid = arr.length / 2;
            // Create two arrays
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];
            // Fill the left array
            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }
            // Fill the right array
            for (int i = mid; i < arr.length; i++) {
                right[i - mid] = arr[i];
            }
            // Recursion
            mergeSort(left);
            mergeSort(right);
            // Merge
            merge(left, right, arr);
        }
    
        // Merge two arrays
        public void merge(int[] left, int[] right, int[] arr) {
            // Create three index variables
            int i = 0, j = 0, k = 0;
            // Compare the elements in the left and right arrays
            while (i < left.length && j < right.length) {
                // If the left element is smaller than the right element, store it in the array
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                }
                // If the right element is smaller than the left element, store it in the array
                else {
                    arr[k++] = right[j++];
                }
            }
            // If there are still elements in the left array, store them in the array
            while (i < left.length) {
                arr[k++] = left[i++];
            }
            // If there are still elements in the right array, store them in the array
            while (j < right.length) {
                arr[k++] = right[j++];
            }
        }
}
