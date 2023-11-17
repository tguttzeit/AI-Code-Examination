package Copilot.MergeSort.T27;

public class MergeSort {
    public void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >>> 1;
        mergeSort(array, temp, left, mid);
        mergeSort(array, temp, mid + 1, right);
        merge(array, temp, left, mid, right);
    }

    private void merge(int[] array, int[] temp, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;

        for (int i = left; i <= right; ++i) {
            temp[i] = array[i];
        }

        for (int i = left; i <= right; ++i) {
            if (leftIndex > mid) {
                array[i] = temp[rightIndex++];
            } else if (rightIndex > right) {
                array[i] = temp[leftIndex++];
            } else if (temp[leftIndex] < temp[rightIndex]) {
                array[i] = temp[leftIndex++];
            } else {
                array[i] = temp[rightIndex++];
            }
        }
    }
}
