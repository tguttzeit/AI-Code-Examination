package Copilot.MergeSort.T49;

public class MergeSort {
    public void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }
    private void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) return;
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, temp, leftStart, middle);
        mergeSort(array, temp, middle + 1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);
    }
    private void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2, rightStart = leftEnd + 1;
        int left = leftStart, right = rightStart, index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) temp[index++] = array[left++];
            else temp[index++] = array[right++];
        }
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, rightEnd - leftStart + 1);
    }
}
