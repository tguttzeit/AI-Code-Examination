class QuickSort:
    def sort(self, arr):
        if arr is None or len(arr) == 0:
            return
        self.quick_sort(arr, 0, len(arr) - 1)

    def quick_sort(self, arr, left, right):
        if left >= right:
            return
        pivot = arr[left + (right - left) // 2]
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
                self.swap(arr, left, right)
                left += 1
                right -= 1
        return left

    def swap(self, arr, left, right):
        temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
