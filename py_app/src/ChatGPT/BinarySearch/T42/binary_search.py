class BinarySearch:
    def binary_search(self, target, arr):
        left, right = 0, len(arr) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if arr[mid] == target:
                return True  # Found the target
            elif arr[mid] < target:
                left = mid + 1  # Target must be in the right half
            else:
                right = mid - 1  # Target must be in the left half

        return False  # Target not found
