class QuickSort:
    def sort(self, nums):
        if len(nums) <= 1:
            return nums
        else:
            pivot = nums[0]
            left = []
            right = []
            for num in nums[1:]:
                if num <= pivot:
                    left.append(num)
                else:
                    right.append(num)
            return self.sort(left) + [pivot] + self.sort(right)
