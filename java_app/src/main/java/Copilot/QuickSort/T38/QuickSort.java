package Copilot.QuickSort.T38;

public class QuickSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private void sort(int[] arr, int low, int high) {
        // Base case
        if (low >= high) {
            return;
        }

        // Recursively call sort() with updated pivot
        int pivot = partition(arr, low, high);
        sort(arr, low, pivot-1);
        sort(arr, pivot+1, high);
    }

    // Partition array into two halves
    private int partition(int[] arr, int low, int high) {
        // Select pivot element (last element)
        int pivot = arr[high];

        // Index of smaller element and indicates the right position of pivot found so far
        int i = (low-1);

        // Iterate through array
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                // Increment index of smaller element
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        // Return index of pivot element
        return i+1;
    }

}
