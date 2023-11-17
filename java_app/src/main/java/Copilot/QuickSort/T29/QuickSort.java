package Copilot.QuickSort.T29;

public class QuickSort {

    // The sort(int[]) method should accept an integer array and sort the array in ascending order.
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // The sort(int[]) method should accept an integer array and sort the array in ascending order.
    private void quickSort(int[] arr, int low, int high) {
        // Create a partition method that returns an integer.
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            // The quickSort(int[], int, int) method should call itself recursively to sort the left and right partitions.
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Create a partition method that returns an integer.
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int partitionIndex = low;
        // The partition method should swap elements in the array as necessary.
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(arr, partitionIndex, high);
        return partitionIndex;
    }

    // The partition method should swap elements in the array as necessary.
    private void swap(int[] arr, int i, int partitionIndex) {
        int temp = arr[i];
        arr[i] = arr[partitionIndex];
        arr[partitionIndex] = temp;
    }

}
