package ChatGPT.MergeSort.T12;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: already sorted or empty array
        }

        int n = arr.length;
        int mid = n / 2;

        int[] left = new int[mid];
        int[] right = new int[n - mid];

        // Fill the left and right subarrays
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, n - mid);

        // Recursively sort the left and right subarrays
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted subarrays
        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            arr[k++] = left[i++];
        }

        while (j < rightLength) {
            arr[k++] = right[j++];
        }
    }
}

