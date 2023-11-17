package Copilot.MergeSort.T19;

public class MergeSort {
    public void mergeSort(int[] a) {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp, 0, a.length-1);
    }

    private void mergeSort(int[] a, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left+right)/2;
            mergeSort(a, tmp, left, mid);
            mergeSort(a, tmp, mid+1, right);
            merge(a, tmp, left, mid+1, right);
        }
    }

    private void merge(int[] a, int[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right-1;
        int k = left;
        int num = rightEnd-left+1;

        while (left <= leftEnd && right <= rightEnd) {
            if (a[left] <= a[right]) {
                tmp[k++] = a[left++];
            } else {
                tmp[k++] = a[right++];
            }
        }

        while (left <= leftEnd) {
            tmp[k++] = a[left++];
        }

        while (right <= rightEnd) {
            tmp[k++] = a[right++];
        }

        for (int i = 0; i < num; i++, rightEnd--) {
            a[rightEnd] = tmp[rightEnd];
        }
    }
}
