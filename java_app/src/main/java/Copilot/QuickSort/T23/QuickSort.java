package Copilot.QuickSort.T23;

public class QuickSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = arr[(start + end) / 2];
        int left = start;
        int right = end;

        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }
}
