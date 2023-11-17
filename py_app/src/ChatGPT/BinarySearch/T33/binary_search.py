class BinarySearch:
    def binary_search(self, target, arr):
        left, right = 0, len(arr) - 1

        while left <= right:
            mid = left + (right - left) // 2  # Calculate the middle index

            if arr[mid] == target:
                return True  # Target found
            elif arr[mid] < target:
                left = mid + 1  # Adjust the left boundary
            else:
                right = mid - 1  # Adjust the right boundary

        return False  # Target not found
