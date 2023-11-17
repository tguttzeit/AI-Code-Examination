class QuickSort:
    def sort(self, arr):
        if len(arr) <= 1:
            return arr

        self.quick_sort(arr, 0, len(arr) - 1)

    def quick_sort(self, arr, low, high):
        if low < high:
            pivot_index = self.partition(arr, low, high)
            self.quick_sort(arr, low, pivot_index - 1)
            self.quick_sort(arr, pivot_index + 1, high)

    def partition(self, arr, low, high):
        pivot = arr[high]
        i = low - 1

        for j in range(low, high):
            if arr[j] <= pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]

        arr[i + 1], arr[high] = arr[high], arr[i + 1]
        return i + 1
