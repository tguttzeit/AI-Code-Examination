class BinarySearch:

    def binary_search(self, target, nums):
        if not nums:
            return False

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            if target == nums[mid]:
                return True
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1

        return False
