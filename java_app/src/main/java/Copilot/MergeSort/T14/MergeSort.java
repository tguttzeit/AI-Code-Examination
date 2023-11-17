package Copilot.MergeSort.T14;

public class MergeSort {
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // recursive method
    private void mergeSort(int[] arr, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }
        // recursive case
        int mid = (left + right) / 2; // find the middle index
        mergeSort(arr, left, mid); // sort the left half
        mergeSort(arr, mid + 1, right); // sort the right half
        merge(arr, left, mid, right); // merge the sorted halves
    }

    // helper method to merge two sorted halves
    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // temp array
        int i = left; // index of left half
        int j = mid + 1; // index of right half
        int k = 0; // index of temp
        // compare the elements of the left and right halves
        // copy the smaller element to the temp array
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }
        // copy the remaining elements of the left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // copy the remaining elements of the right half
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // copy the sorted temp array back to the original array
        for (int m = 0; m < temp.length; m++) {
            arr[left + m] = temp[m];
        }
    }
}
