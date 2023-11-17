package Copilot.QuickSort.T16;

public class QuickSort {

    // Implement a non-static quick sort algorithm class named QuickSort with a public void sort(int[]) method.
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Implement a recursive quick sort algorithm in the sort(int[]) method.
    // The quick sort algorithm should be implemented using the Hoare partition scheme.
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p);
            quickSort(arr, p + 1, high);
        }
    }

    // Implement a recursive quick sort algorithm in the sort(int[]) method.
    // The quick sort algorithm should be implemented using the Hoare partition scheme.
    // The partition(int[], int, int) method should return the index of the pivot element.
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i < j) {
                swap(arr, i, j);
            } else {
                return j;
            }
        }
    }

    // Implement a recursive quick sort algorithm in the sort(int[]) method.
    // The quick sort algorithm should be implemented using the Hoare partition scheme.
    // The partition(int[], int, int) method should return the index of the pivot element.
    // The quickSort(int[], int, int) method should be implemented using the first element as pivot.
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];

        arr[i] = arr[j];
        arr[j] = temp;
    }

}
