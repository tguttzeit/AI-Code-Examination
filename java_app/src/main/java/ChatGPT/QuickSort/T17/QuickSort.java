package ChatGPT.QuickSort.T17;

public class QuickSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: already sorted or empty array
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // Partition the array
            quickSort(arr, low, pivotIndex - 1); // Recursively sort the left subarray
            quickSort(arr, pivotIndex + 1, high); // Recursively sort the right subarray
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the pivot as the last element
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // Swap arr[i] and arr[j]
            }
        }

        swap(arr, i + 1, high); // Swap the pivot element to its correct position
        return i + 1; // Return the index of the pivot element
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
