class BinarySearch:
    # Implement the binary_search() method here.
    def binary_search(self, target, nums):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = int((low + high) / 2)
            if nums[mid] < target:
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            elif nums[mid] == target:
                return True

        return False
