package Copilot.QuickSort.T19;

public class QuickSort {

    // The sort method should accept an array of integers and sort them in ascending order.
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // The quick sort algorithm should be implemented using the recursive approach.
    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[(left + right) / 2];
        int index = partition(arr, left, right, pivot);

        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    // The partition method should accept an array of integers, left and right indexes and a pivot value.
    private int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);

                left++;
                right--;
            }
        }

        return left;
    }

    // The swap method should accept an array of integers and two indexes.
    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
