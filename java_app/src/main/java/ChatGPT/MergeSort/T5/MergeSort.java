package ChatGPT.MergeSort.T5;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: array is already sorted or empty
        }
        
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        
        // Split the array into left and right halves
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);
        
        // Recursively sort the left and right halves
        mergeSort(left);
        mergeSort(right);
        
        // Merge the sorted halves
        merge(arr, left, right);
    }
    
    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0; // Index for the left array
        int j = 0; // Index for the right array
        int k = 0; // Index for the merged array
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        
        // Copy any remaining elements from left and right arrays
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}

