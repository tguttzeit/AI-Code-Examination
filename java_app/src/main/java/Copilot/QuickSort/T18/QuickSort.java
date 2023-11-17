package Copilot.QuickSort.T18;

public class QuickSort {

    // Implement a non-static quick sort algorithm class named QuickSort with a public void sort(int[]) method.
    public void sort(int[] arr) {
        // Call the recursive quick sort method.
        quickSort(arr, 0, arr.length - 1);
    }

    // Implement a recursive quick sort method with the following signature:
    // private void quickSort(int[], int, int)
    private void quickSort(int[] arr, int low, int high) {
        // If the low index is less than the high index, partition the array and sort the two partitions.
        if (low < high) {
            // Partition the array.
            int partitionIndex = partition(arr, low, high);

            // Sort the two partitions.
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Implement a private partition method with the following signature:
    // private int partition(int[], int, int)
    private int partition(int[] arr, int low, int high) {
        // Select the pivot as the last element in the array.
        int pivot = arr[high];

        // Initialize the partition index to the low index.
        int partitionIndex = low;

        // For each element in the array, if the element is less than the pivot, swap the element with the element at the partition index and increment the partition index.
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }

        // Swap the element at the partition index with the pivot.
        swap(arr, partitionIndex, high);

        // Return the partition index.
        return partitionIndex;
    }

    // Implement a private swap method with the following signature:
    // private void swap(int[], int, int)
    private void swap(int[] arr, int index1, int index2) {
        // Store the element at index1 in a temporary variable.
        int temp = arr[index1];

        // Set the element at index1 to the element at index2.
        arr[index1] = arr[index2];

        // Set the element at index2 to the temporary variable.
        arr[index2] = temp;
    }

}
