class QuickSort:
    def sort(self, arr):
        if not arr:
            return

        self._quick_sort(arr, 0, len(arr) - 1)

    def _quick_sort(self, arr, low, high):
        if low < high:
            # Partition the array and get the pivot index
            pivot_index = self._partition(arr, low, high)

            # Recursively sort the two sub-arrays
            self._quick_sort(arr, low, pivot_index - 1)
            self._quick_sort(arr, pivot_index + 1, high)

    def _partition(self, arr, low, high):
        # Choose the rightmost element as the pivot
        pivot = arr[high]
        # Index of the smaller element
        i = low - 1

        for j in range(low, high):
            if arr[j] <= pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]

        # Place the pivot element in its correct position
        arr[i + 1], arr[high] = arr[high], arr[i + 1]

        return i + 1
