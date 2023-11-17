package Copilot.MergeSort.T23;

public class MergeSort {
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int left, int right) {
        // base case
        if (left >= right) return;
        // divide
        int mid = left + (right - left) / 2;
        // conquer
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        // merge
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        // create two new arrays to store divided arrays
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];
        // copy divided arrays
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }
        // merge two arrays
        int leftIndex = 0, rightIndex = 0, index = left;
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                arr[index++] = leftArr[leftIndex++];
            } else {
                arr[index++] = rightArr[rightIndex++];
            }
        }
        // copy remaining elements
        while (leftIndex < leftArr.length) {
            arr[index++] = leftArr[leftIndex++];
        }
        while (rightIndex < rightArr.length) {
            arr[index++] = rightArr[rightIndex++];
        }
    }
}
