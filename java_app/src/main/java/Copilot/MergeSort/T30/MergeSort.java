package Copilot.MergeSort.T30;

public class MergeSort {
    public void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];

            for (int i = 0; i < left.length; i++) {
                left[i] = array[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = array[mid + i];
            }

            mergeSort(left);
            mergeSort(right);
            merge(left, right, array);
        }
    }

    private void merge(int[] left, int[] right, int[] array) {
        int leftPointer = 0;
        int rightPointer = 0;
        int arrayPointer = 0;

        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer] <= right[rightPointer]) {
                array[arrayPointer] = left[leftPointer];
                leftPointer++;
            } else {
                array[arrayPointer] = right[rightPointer];
                rightPointer++;
            }
            arrayPointer++;
        }

        while (leftPointer < left.length) {
            array[arrayPointer] = left[leftPointer];
            leftPointer++;
            arrayPointer++;
        }

        while (rightPointer < right.length) {
            array[arrayPointer] = right[rightPointer];
            rightPointer++;
            arrayPointer++;
        }
    }
}
