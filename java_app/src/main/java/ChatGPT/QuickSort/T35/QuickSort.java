package ChatGPT.QuickSort.T35;

public class QuickSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: Already sorted or empty array
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high); // Find the partition index
            quickSort(arr, low, partitionIndex - 1); // Recursively sort elements before the partition
            quickSort(arr, partitionIndex + 1, high); // Recursively sort elements after the partition
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the pivot as the last element
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high); // Place the pivot in its correct position
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
