package Copilot.MergeSort.AIGenerated.T3;

public class MergeSort {
    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
    }

    private void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) return;
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(arr, temp, leftStart, middle);
        mergeSort(arr, temp, middle+1, rightEnd);
        mergeHalves(arr, temp, leftStart, rightEnd);
    }

    private void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = (leftStart + rightEnd)/2 + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) temp[index++] = arr[left++];
            else temp[index++] = arr[right++];
        }

        System.arraycopy(arr, left, temp, index, leftEnd-left+1);
        System.arraycopy(arr, right, temp, index, rightEnd-right+1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }
}
