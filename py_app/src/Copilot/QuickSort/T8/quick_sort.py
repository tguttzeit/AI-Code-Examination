class QuickSort:
    def sort(self, a):
        self.quick_sort(a, 0, len(a) - 1)
        return a

    def quick_sort(self, a, left, right):
        if left >= right:
            return
        pivot = a[(left + right) // 2]
        index = self.partition(a, left, right, pivot)
        self.quick_sort(a, left, index - 1)
        self.quick_sort(a, index, right)

    def partition(self, a, left, right, pivot):
        while left <= right:
            while a[left] < pivot:
                left += 1
            while a[right] > pivot:
                right -= 1
            if left <= right:
                self.swap(a, left, right)
                left += 1
                right -= 1
        return left

    def swap(self, a, left, right):
        temp = a[left]
        a[left] = a[right]
        a[right] = temp
