package Copilot.QuickSort.T42;

public class QuickSort {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Use the quick sort algorithm to sort the array.
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Takes last element as pivot, places the pivot element at its correct position in sorted array, and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        // index of smaller element
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // return the position from where partition is done
        return i + 1;
    }
}
