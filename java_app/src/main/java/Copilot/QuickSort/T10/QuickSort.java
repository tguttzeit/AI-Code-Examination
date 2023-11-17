package Copilot.QuickSort.T10;

public class QuickSort {

    public void sort(int[] arr) {
        // call quickSort(arr, 0, arr.length - 1) to sort the array
        quickSort(arr, 0, arr.length - 1);
    }

    // Implement the quickSort(int[], int, int) method to sort the array.
    private void quickSort(int[] arr, int low, int high) {
        // if low < high, then
        if (low < high) {
            // call partition(arr, low, high) to partition the array
            int pi = partition(arr, low, high);

            // call quickSort(arr, low, pi - 1) to sort the left sub-array
            quickSort(arr, low, pi - 1);

            // call quickSort(arr, pi + 1, high) to sort the right sub-array
            quickSort(arr, pi + 1, high);
        }
    }

    // Implement the partition(int[], int, int) method to partition the array.
    private int partition(int[] arr, int low, int high) {
        // set pivot to arr[high]
        int pivot = arr[high];

        // set i to low - 1
        int i = low - 1;

        // for j = low to high - 1, do
        for (int j = low; j < high; j++) {
            // if arr[j] < pivot, then
            if (arr[j] < pivot) {
                // increment i by 1
                i++;

                // swap arr[i] with arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i + 1] with arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // return i + 1
        return i + 1;
    }

}
