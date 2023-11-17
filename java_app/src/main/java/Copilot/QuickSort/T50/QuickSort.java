package Copilot.QuickSort.T50;

public class QuickSort {

    // The public void sort(int[]) method should sort the input array of integers in ascending order.
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // The public void sort(int[]) method should sort the input array of integers in ascending order.
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // The public void sort(int[]) method should sort the input array of integers in ascending order.
    private int partition(int[] arr, int low, int high) {
        // pivot (Element to be placed at right position)
        int pivot = arr[high];

        // Index of smaller element and indicates the right position of pivot found so far
        int i = (low - 1);

        // Traverse all elements in the array
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[high] = temp;

        // Return the partitioning index
        return i + 1;
    }

}
