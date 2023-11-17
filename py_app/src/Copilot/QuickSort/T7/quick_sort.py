class QuickSort:

    def __init__(self):
        self.counter = 0

    def sort(self, arr):
        self.quickSort(arr, 0, len(arr) - 1)
        return arr

    def quickSort(self, arr, low, high):
        if low < high:
            p = self.partition(arr, low, high)
            self.quickSort(arr, low, p - 1)
            self.quickSort(arr, p + 1, high)

    def partition(self, arr, low, high):
        pivot = arr[high]
        i = low - 1
        for j in range(low, high):
            self.counter += 1
            if arr[j] < pivot:
                i = i + 1
                arr[i], arr[j] = arr[j], arr[i]
        arr[i + 1], arr[high] = arr[high], arr[i + 1]
        return i + 1
