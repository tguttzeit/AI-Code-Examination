class QuickSort:
    def sort(self, nums):
        self.quick_sort(nums, 0, len(nums) - 1)

    def quick_sort(self, nums, low, high):
        if low >= high:
            return
        pivot = self.partition(nums, low, high)
        self.quick_sort(nums, low, pivot - 1)
        self.quick_sort(nums, pivot + 1, high)

    def partition(self, nums, low, high):
        pivot = nums[high]
        i = low
        for j in range(low, high):
            if nums[j] < pivot:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
        nums[i], nums[high] = nums[high], nums[i]
        return i
