package ChatGPT.MergeSort.T14;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: already sorted or empty
        }
        
        int n = arr.length;
        int mid = n / 2;
        
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        
        // Populate left and right subarrays
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }
        
        // Recursively sort left and right subarrays
        mergeSort(left);
        mergeSort(right);
        
        // Merge sorted subarrays
        merge(arr, left, right);
    }
    
    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}

