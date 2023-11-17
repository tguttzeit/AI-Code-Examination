package ChatGPT.MergeSort.T22;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // No need to sort an array of size 0 or 1
        }
        
        int n = arr.length;
        int[] temp = new int[n];
        mergeSortHelper(arr, temp, 0, n - 1);
    }

    private void mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSortHelper(arr, temp, left, mid);       // Sort left half
            mergeSortHelper(arr, temp, mid + 1, right);  // Sort right half
            
            merge(arr, temp, left, mid, right);          // Merge the sorted halves
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy elements to the temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        
        int i = left;
        int j = mid + 1;
        int k = left;
        
        // Merge the two halves back into the original array
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        
        // Copy remaining elements from the left half, if any
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        
        // Copy remaining elements from the right half, if any
        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }
}

