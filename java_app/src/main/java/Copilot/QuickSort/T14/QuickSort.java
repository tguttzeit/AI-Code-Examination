package Copilot.QuickSort.T14;

public class QuickSort {

    // Quick sort the integer array
    public void sort(int[] array) {
        // Call the quick sort helper method
        quickSort(array, 0, array.length - 1);
    }

    // Quick sort helper method
    private void quickSort(int[] array, int start, int end) {
        // If the start index is less than the end index
        if (start < end) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, start, end);

            // Quick sort the left side of the array
            quickSort(array, start, pivotIndex - 1);

            // Quick sort the right side of the array
            quickSort(array, pivotIndex + 1, end);
        }
    }

    // Partition the array and return the pivot index
    private int partition(int[] array, int start, int end) {
        // Set the pivot to the last element in the array
        int pivot = array[end];

        // Set the partition index to the start
        int partitionIndex = start;

        // Loop through the array from the start to end
        for (int i = start; i < end; i++) {
            // If the current element is less than the pivot
            if (array[i] < pivot) {
                // Swap the current element with the element at the partition index
                swap(array, i, partitionIndex);

                // Increment the partition index
                partitionIndex++;
            }
        }

        // Swap the element at the partition index with the pivot
        swap(array, partitionIndex, end);

        // Return the partition index
        return partitionIndex;
    }

    // Swap the elements at the given indices in the array
    private void swap(int[] array, int index1, int index2) {
        // Store the element at the first index
        int temp = array[index1];

        // Set the element at the first index to the element at the second index
        array[index1] = array[index2];

        // Set the element at the second index to the stored element
        array[index2] = temp;
    }

}
