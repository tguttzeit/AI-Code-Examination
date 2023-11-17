class QuickSort:

    def sort(self, nums):
        self.quick_sort(nums, 0, len(nums) - 1)

    def quick_sort(self, nums, left, right):
        if left >= right:
            return

        pivot = self.partition(nums, left, right)
        self.quick_sort(nums, left, pivot - 1)
        self.quick_sort(nums, pivot + 1, right)

    def partition(self, nums, left, right):
        pivot = nums[right]
        i = left - 1

        for j in range(left, right):
            if nums[j] < pivot:
                i += 1
                self.swap(nums, i, j)

        self.swap(nums, i + 1, right)
        return i + 1

    def swap(self, nums, i, j):
        nums[i], nums[j] = nums[j], nums[i]
