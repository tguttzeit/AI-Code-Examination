class QuickSort:
    def sort(self, nums):
        self.quick_sort(nums, 0, len(nums) - 1)

    def quick_sort(self, nums, start, end):
        if start >= end:
            return

        pivot = self.partition(nums, start, end)
        self.quick_sort(nums, start, pivot - 1)
        self.quick_sort(nums, pivot + 1, end)

    def partition(self, nums, start, end):
        pivot = nums[end]
        i = start
        for j in range(start, end):
            if nums[j] < pivot:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1

        nums[i], nums[end] = nums[end], nums[i]
        return i
