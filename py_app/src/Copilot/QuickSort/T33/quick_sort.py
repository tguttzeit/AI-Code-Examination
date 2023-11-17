class QuickSort:
    def sort(self, nums):
        self.quickSort(nums, 0, len(nums)-1)

    def quickSort(self, nums, low, high):
        if low < high:
            pivot = self.partition(nums, low, high)
            self.quickSort(nums, low, pivot-1)
            self.quickSort(nums, pivot+1, high)

    def partition(self, nums, low, high):
        i = low - 1
        pivot = nums[high]
        for j in range(low, high):
            if nums[j] <= pivot:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
        nums[i+1], nums[high] = nums[high], nums[i+1]
        return i+1
