class BinarySearch:

    def binary_search(self, target: int, nums: list[int]) -> bool:
        left = 0
        right = len(nums) - 1
        while left <= right:
            middle = left + (right - left) // 2
            if nums[middle] == target:
                return True
            elif nums[middle] > target:
                right = middle - 1
            else:
                left = middle + 1
        return False
