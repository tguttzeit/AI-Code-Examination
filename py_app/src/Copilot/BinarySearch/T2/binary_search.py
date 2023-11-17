class BinarySearch:

    def binary_search(self, target, nums):
        if not nums:
            return False

        pivot = len(nums) // 2

        if nums[pivot] == target:
            return True
        elif nums[pivot] > target:
            return self.binary_search(target, nums[:pivot])
        else:
            return self.binary_search(target, nums[pivot + 1:])
