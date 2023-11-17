class QuickSort:
    def sort(self, nums):
        if len(nums) <= 1:
            return nums
        pivot = nums[len(nums) // 2]
        left = [x for x in nums if x < pivot]
        middle = [x for x in nums if x == pivot]
        right = [x for x in nums if x > pivot]
        return self.sort(left) + middle + self.sort(right)
