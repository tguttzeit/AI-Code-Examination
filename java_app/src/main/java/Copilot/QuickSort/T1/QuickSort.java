package Copilot.QuickSort.T1;

public class QuickSort {

    // Implement the quick sort algorithm as described in the lecture slides.
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Implement a private void quickSort(int[], int, int) method that recursively sorts the array.
    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);

            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    // Implement a private int partition(int[], int, int) method that partitions the array.
    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int pivotIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i] <= pivot) {
                swap(array, i, pivotIndex);
                pivotIndex++;
            }
        }

        swap(array, pivotIndex, right);

        return pivotIndex;
    }

    // Implement a private void swap(int[], int, int) method that swaps the two elements in the array.
    private void swap(int[] array, int first, int second) {
        int temp = array[second];

        array[second] = array[first];
        array[first] = temp;
    }


}
