package ChatGPT.MergeSort.T15;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: already sorted or empty array
        }
        
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        
        // Populate the left and right subarrays
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);
        
        // Recursively sort the left and right subarrays
        mergeSort(left);
        mergeSort(right);
        
        // Merge the sorted subarrays
        merge(arr, left, right);
    }
    
    private void merge(int[] arr, int[] left, int[] right) {
        int leftIdx = 0, rightIdx = 0, arrIdx = 0;
        
        // Compare elements from both subarrays and merge them
        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] <= right[rightIdx]) {
                arr[arrIdx++] = left[leftIdx++];
            } else {
                arr[arrIdx++] = right[rightIdx++];
            }
        }
        
        // Copy remaining elements from left and right subarrays, if any
        while (leftIdx < left.length) {
            arr[arrIdx++] = left[leftIdx++];
        }
        
        while (rightIdx < right.length) {
            arr[arrIdx++] = right[rightIdx++];
        }
    }
}
