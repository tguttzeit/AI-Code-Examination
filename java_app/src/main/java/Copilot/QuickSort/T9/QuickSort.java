package Copilot.QuickSort.T9;

public class QuickSort {

    public void sort(int[] array) {
        // Call the sort(int[], int, int) method with the correct parameters.
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int low, int high) {
        // Check if the array is null or empty.
        if (array == null || array.length == 0) {
            return;
        }

        // Check if the low index is lower than the high index.
        if (low < high) {
            // Partition the array and get the pivot index.
            int pivotIndex = partition(array, low, high);

            // Sort the left side of the pivot index.
            sort(array, low, pivotIndex - 1);

            // Sort the right side of the pivot index.
            sort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        // Get the pivot element.
        int pivot = array[high];

        // Get the index of the lowest element.
        int i = low - 1;

        // Loop through the array.
        for (int j = low; j < high; j++) {
            // Check if the current element is less than the pivot element.
            if (array[j] < pivot) {
                // Increment the lowest element index.
                i++;

                // Swap the elements.
                swap(array, i, j);
            }
        }

        // Swap the pivot element with the highest element.
        swap(array, i + 1, high);

        // Return the pivot index.
        return i + 1;
    }

    private void swap(int[] array, int indexA, int indexB) {
        // Get the element at indexA.
        int temp = array[indexA];

        // Set the element at indexA to the element at indexB.
        array[indexA] = array[indexB];

        // Set the element at indexB to the element at indexA.
        array[indexB] = temp;
    }

}
