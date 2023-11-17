class BinarySearch:
    def binary_search(self, target, nums):
        left = 0
        right = len(nums) - 1

        while left <= right:
            middle = (left + right) // 2
            if target == nums[middle]:
                return True
            elif target < nums[middle]:
                right = middle - 1
            else:
                left = middle + 1

        return False
