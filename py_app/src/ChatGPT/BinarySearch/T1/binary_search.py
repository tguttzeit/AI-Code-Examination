class BinarySearch:
    def binary_search(self, target, nums):
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2  # Calculate the middle index
            if nums[mid] == target:
                return True  # Found the target
            elif nums[mid] < target:
                left = mid + 1  # Adjust the left boundary
            else:
                right = mid - 1  # Adjust the right boundary

        return False  # Target not found
