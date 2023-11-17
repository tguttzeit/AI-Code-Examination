package Copilot.MergeSort.T45;

public class MergeSort {
    public void mergeSort(int[] list) {
        if (list.length > 1) {
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            int[] temp = merge(firstHalf, secondHalf);
            System.arraycopy(temp, 0, list, 0, list.length);
        }
    }

    public int[] merge(int[] list1, int[] list2) {
        int[] temp = new int[list1.length + list2.length];
        int currentIndexList1 = 0;
        int currentIndexList2 = 0;
        int currentIndexTemp = 0;

        while (currentIndexList1 < list1.length && currentIndexList2 < list2.length) {
            if (list1[currentIndexList1] < list2[currentIndexList2]) {
                temp[currentIndexTemp++] = list1[currentIndexList1++];
            } else {
                temp[currentIndexTemp++] = list2[currentIndexList2++];
            }
        }

        while (currentIndexList1 < list1.length) {
            temp[currentIndexTemp++] = list1[currentIndexList1++];
        }

        while (currentIndexList2 < list2.length) {
            temp[currentIndexTemp++] = list2[currentIndexList2++];
        }

        return temp;
    }
}
