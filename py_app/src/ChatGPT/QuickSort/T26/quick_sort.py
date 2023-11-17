class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        self._quick_sort(arr, 0, len(arr) - 1)

    def _quick_sort(self, arr, low, high):
        if low < high:
            # Partition the array and get the pivot index
            pivot_index = self._partition(arr, low, high)

            # Recursively sort the sub-arrays on both sides of the pivot
            self._quick_sort(arr, low, pivot_index - 1)
            self._quick_sort(arr, pivot_index + 1, high)

    def _partition(self, arr, low, high):
        pivot = arr[high]
        i = low - 1  # Index of smaller element

        for j in range(low, high):
            if arr[j] < pivot:
                # Swap arr[i] and arr[j]
                i += 1
                arr[i], arr[j] = arr[j], arr[i]

        # Swap arr[i+1] and arr[high] (pivot)
        arr[i + 1], arr[high] = arr[high], arr[i + 1]

        return i + 1
