class QuickSort:
    def sort(self, nums):
        if len(nums) <= 1:
            return nums
        pivot = nums[0]
        left = []
        right = []
        for i in range(1, len(nums)):
            if nums[i] < pivot:
                left.append(nums[i])
            else:
                right.append(nums[i])
        return self.sort(left) + [pivot] + self.sort(right)
