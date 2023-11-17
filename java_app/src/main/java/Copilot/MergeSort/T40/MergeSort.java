package Copilot.MergeSort.T40;

public class MergeSort {
    public void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (right - left) / 2 + left;
        mergeSort(array, helper, left, middle);
        mergeSort(array, helper, middle + 1, right);
        merge(array, helper, left, middle, right);
    }

    private void merge(int[] array, int[] helper, int left, int middle, int right) {
        // copy the original array to helper array
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }

        // merge two sorted array
        int leftIndex = left;
        int rightIndex = middle + 1;
        while (leftIndex <= middle && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        while (leftIndex <= middle) {
            array[left++] = helper[leftIndex++];
        }
    }
}
