
class BinarySearch:
    def __init__(self):
        pass

    def binary_search(self, target, nums):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (high + low) // 2
            if nums[mid] == target:
                return True
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return False
