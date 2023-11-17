package ChatGPT.MergeSort.T6;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: already sorted or empty array
        }
        
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        
        // Split the array into left and right halves
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        
        // Recursively sort the two halves
        mergeSort(left);
        mergeSort(right);
        
        // Merge the sorted halves
        merge(arr, left, right);
    }
    
    private void merge(int[] arr, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;
        
        // Compare and merge elements from left and right arrays
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                arr[mergedIndex++] = left[leftIndex++];
            } else {
                arr[mergedIndex++] = right[rightIndex++];
            }
        }
        
        // Copy remaining elements from left and right arrays, if any
        while (leftIndex < left.length) {
            arr[mergedIndex++] = left[leftIndex++];
        }
        
        while (rightIndex < right.length) {
            arr[mergedIndex++] = right[rightIndex++];
        }
    }
}

