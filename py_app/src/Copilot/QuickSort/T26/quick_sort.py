class QuickSort:
    def __init__(self):
        pass

    def sort(self, arr):
        if arr == None or len(arr) == 0:
            return arr
        self.quickSort(arr, 0, len(arr) - 1)

    def quickSort(self, arr, low, high):
        if low < high:
            pivot = self.partition(arr, low, high)
            self.quickSort(arr, low, pivot - 1)
            self.quickSort(arr, pivot + 1, high)

    def partition(self, arr, low, high):
        pivot = arr[high]
        i = low - 1
        for j in range(low, high):
            if arr[j] < pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]
        arr[i+1], arr[high] = arr[high], arr[i+1]
        return i + 1
