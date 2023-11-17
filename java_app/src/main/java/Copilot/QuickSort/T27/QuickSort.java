package Copilot.QuickSort.T27;

public class QuickSort {

    public void sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Takes last element as pivot, places
    // the pivot element at its correct
    // position in sorted array, and
    // places all smaller (smaller than
    // pivot) to left of pivot and all
    // greater elements to right of pivot
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void swap(int[] arr, int i, int j) {
        // Swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
