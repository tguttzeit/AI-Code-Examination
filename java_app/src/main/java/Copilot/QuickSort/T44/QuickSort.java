package Copilot.QuickSort.T44;

public class QuickSort {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Implement a private void quickSort(int[], int, int) method that recursively sorts the array.
    private void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // Use the partition method to get the pivot index.
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after the pivot index.
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Implement a private int partition(int[], int, int) method that selects a pivot element and partitions the array around the selected pivot.
    private int partition(int arr[], int low, int high) {
        // Select the last element as the pivot.
        int pivot = arr[high];

        // Index of smaller element and indicates the right position of pivot found so far.
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot.
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j].
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot).
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return the pivot index.
        return i + 1;
    }

}
