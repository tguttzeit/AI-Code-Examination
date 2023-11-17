package Copilot.MergeSort.T11;

public class MergeSort {
    public void mergeSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        // divide
        int mid = left + (right - left) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);

        // merge
        int[] helper = new int[a.length];
        for (int i = left; i <= right; i++) {
            helper[i] = a[i];
        }
        int i = left;
        int j = mid + 1;
        int index = left;
        while (i <= mid && j <= right) {
            if (helper[i] <= helper[j]) {
                a[index++] = helper[i++];
            } else {
                a[index++] = helper[j++];
            }
        }
        while (i <= mid) {
            a[index++] = helper[i++];
        }
    }
}
