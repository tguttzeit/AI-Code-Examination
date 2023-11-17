class QuickSort:
    def __init__(self):
        pass

    def sort(self, arr):
        self.quick_sort(arr, 0, len(arr) - 1)

    def quick_sort(self, arr, left, right):
        if left < right:
            pivot = self.partition(arr, left, right)
            self.quick_sort(arr, left, pivot - 1)
            self.quick_sort(arr, pivot + 1, right)

    def partition(self, arr, left, right):
        pivot = arr[right]
        i = left - 1

        for j in range(left, right):
            if arr[j] < pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]

        arr[i + 1], arr[right] = arr[right], arr[i + 1]
        return i + 1
