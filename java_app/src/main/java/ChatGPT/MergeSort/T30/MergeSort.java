package ChatGPT.MergeSort.T30;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted or empty
        }
        
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }
    
    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }
    
    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        
        int i = left; // Index for the left subarray
        int j = mid + 1; // Index for the right subarray
        int k = left; // Index for the merged array
        
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}

