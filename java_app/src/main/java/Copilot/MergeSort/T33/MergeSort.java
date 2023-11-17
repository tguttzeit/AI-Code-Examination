package Copilot.MergeSort.T33;

public class MergeSort {
    	// Implement the merge sort algorithm
        public void mergeSort(int[] arr) {
            // Check if array is null or empty
            if (arr == null || arr.length == 0) {
                return;
            }
            // Check if array has one element
            if (arr.length == 1) {
                return;
            }
            // Split array into two halves
            int[] arr1 = new int[arr.length / 2];
            int[] arr2 = new int[arr.length - arr.length / 2];
            for (int i = 0; i < arr.length; i++) {
                if (i < arr.length / 2) {
                    arr1[i] = arr[i];
                } else {
                    arr2[i - arr.length / 2] = arr[i];
                }
            }
            // Recursively sort the two halves
            mergeSort(arr1);
            mergeSort(arr2);
            // Merge the two sorted halves
            int i = 0, j = 0, k = 0;
            while (i < arr1.length || j < arr2.length) {
                if (i < arr1.length && j < arr2.length) {
                    if (arr1[i] < arr2[j]) {
                        arr[k] = arr1[i];
                        i++;
                    } else {
                        arr[k] = arr2[j];
                        j++;
                    }
                } else if (i < arr1.length) {
                    arr[k] = arr1[i];
                    i++;
                } else {
                    arr[k] = arr2[j];
                    j++;
                }
                k++;
            }
        }
}
