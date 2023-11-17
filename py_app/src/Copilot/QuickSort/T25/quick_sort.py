class QuickSort:
    def sort(self, nums):
        self.quickSort(nums, 0, len(nums) - 1)

    def quickSort(self, nums, left, right):
        if left >= right:
            return
        pivot = nums[left]
        i = left
        j = right
        while i < j:
            while i < j and nums[j] >= pivot:
                j -= 1
            nums[i] = nums[j]
            while i < j and nums[i] <= pivot:
                i += 1
            nums[j] = nums[i]
        nums[i] = pivot
        self.quickSort(nums, left, i - 1)
        self.quickSort(nums, i + 1, right)
