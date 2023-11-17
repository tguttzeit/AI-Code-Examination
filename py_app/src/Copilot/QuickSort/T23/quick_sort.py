class QuickSort:
    def sort(self, nums):
        self.quick_sort(nums, 0, len(nums) - 1)

    def quick_sort(self, nums, low, high):
        if low < high:
            pivot = self.partition(nums, low, high)
            self.quick_sort(nums, low, pivot - 1)
            self.quick_sort(nums, pivot + 1, high)

    def partition(self, nums, low, high):
        pivot = nums[high]
        i = low - 1
        for j in range(low, high):
            if nums[j] < pivot:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
        nums[i + 1], nums[high] = nums[high], nums[i + 1]
        return i + 1
