class QuickSort:
    def sort(self, arr):
        self.quick_sort(arr, 0, len(arr) - 1)

    def quick_sort(self, arr, left, right):
        if left >= right:
            return
        pivot = arr[(left + right) // 2]
        index = self.partition(arr, left, right, pivot)
        self.quick_sort(arr, left, index - 1)
        self.quick_sort(arr, index, right)

    def partition(self, arr, left, right, pivot):
        while left <= right:
            while arr[left] < pivot:
                left += 1
            while arr[right] > pivot:
                right -= 1
            if left <= right:
                arr[left], arr[right] = arr[right], arr[left]
                left += 1
                right -= 1
        return left
