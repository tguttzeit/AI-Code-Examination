package Copilot.MergeSort.T24;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }

        int middle = (leftStart + rightEnd) / 2;
        mergeSort(arr, temp, leftStart, middle);
        mergeSort(arr, temp, middle + 1, rightEnd);
        mergeHalves(arr, temp, leftStart, rightEnd);
    }

    public static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = (leftStart + rightEnd + 1) / 2;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        while (left <= leftEnd) {
            temp[index++] = arr[left++];
        }

        while (right <= rightEnd) {
            temp[index++] = arr[right++];
        }

        for (int i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
    }
}
