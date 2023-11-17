package ChatGPT.MergeSort.T31;

public class MergeSort {

    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // No need to sort an empty array or an array with one element
        }
        
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }
    
    private void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Calculate mid index
            
            // Recursively sort the left and right halves of the array
            mergeSort(array, temp, left, mid);
            mergeSort(array, temp, mid + 1, right);
            
            // Merge the two sorted halves
            merge(array, temp, left, mid, right);
        }
    }
    
    private void merge(int[] array, int[] temp, int left, int mid, int right) {
        // Copy data to temporary arrays
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        
        int i = left; // Initial index of first subarray
        int j = mid + 1; // Initial index of second subarray
        int k = left; // Initial index of merged subarray
        
        // Merge the two subarrays
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        
        // Copy the remaining elements of left subarray, if any
        while (i <= mid) {
            array[k] = temp[i];
            i++;
            k++;
        }
        
        // Copy the remaining elements of right subarray, if any
        while (j <= right) {
            array[k] = temp[j];
            j++;
            k++;
        }
    }
}
