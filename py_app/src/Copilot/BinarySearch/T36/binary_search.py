class BinarySearch:

    def binary_search(self, target: int, nums: [int]) -> bool:
        if len(nums) == 0:
            return False

        left = 0
        right = len(nums) - 1

        while left <= right:
            middle = (left + right) // 2

            if nums[middle] == target:
                return True

            if nums[middle] < target:
                left = middle + 1
            else:
                right = middle - 1

        return False
