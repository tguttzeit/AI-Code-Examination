package Copilot.QuickSort.T48;

public class QuickSort {

    // The sort(int[]) method should sort the given array in-place using the quick sort algorithm.
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // The quickSort(int[], int, int) method should sort the given array in-place using the quick sort algorithm.
    // The method should use the first element as the pivot.
    // The method should use the last element as the pivot.
    // The method should use the middle element as the pivot.
    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = start;
            int left = start + 1;
            int right = end;

            while (left < right) {
                while (left <= right && array[left] <= array[pivot]) {
                    left++;
                }
                while (right >= left && array[right] >= array[pivot]) {
                    right--;
                }

                if (left < right) {
                    swap(array, left, right);
                }
            }

            if (right > pivot) {
                swap(array, pivot, right);
                pivot = right;
            }

            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    // The swap(int[], int, int) method should swap the values at the given indices in the given array.
    private void swap(int[] array, int indexA, int indexB) {
        int tempValue = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tempValue;
    }

}
