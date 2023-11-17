package ChatGPT.MergeSort.T37;

public class MergeSort {
    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Base case: an array with 0 or 1 elements is already sorted
        }
        
        int middle = array.length / 2;
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];
        
        // Split the array into left and right halves
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }
        for (int i = middle; i < array.length; i++) {
            right[i - middle] = array[i];
        }
        
        // Recursively sort the left and right halves
        mergeSort(left);
        mergeSort(right);
        
        // Merge the sorted halves
        merge(array, left, right);
    }
    
    private void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            result[k++] = left[i++];
        }
        
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}
