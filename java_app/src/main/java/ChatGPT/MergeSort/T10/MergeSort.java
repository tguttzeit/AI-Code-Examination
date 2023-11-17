package ChatGPT.MergeSort.T10;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: already sorted or empty
        }
        
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        
        // Populate left and right arrays
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
        
        // Recursive mergeSort on left and right arrays
        mergeSort(left);
        mergeSort(right);
        
        // Merge sorted left and right arrays
        merge(arr, left, right);
    }
    
    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0; // Index for left array
        int j = 0; // Index for right array
        int k = 0; // Index for merged array
        
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
