package Copilot.QuickSort.T39;

public class QuickSort {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // pi is the partitioning index, arr[pi] is now at the right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // This function takes the last element as pivot, places the pivot element at its correct position in sorted array,
    // and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
    private int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // pivot
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; ++j) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        swap(arr, i + 1, high);

        return i + 1;
    }

    // Swap two elements in an array
    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
