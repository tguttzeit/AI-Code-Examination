class BinarySearch:
    def binary_search(self, target, arr):
        left = 0
        right = len(arr) - 1

        while left <= right:
            mid = left + (right - left) // 2  # Calculate the middle index

            if arr[mid] == target:
                return True  # Target found
            elif arr[mid] < target:
                left = mid + 1  # Search the right half
            else:
                right = mid - 1  # Search the left half

        return False  # Target not found
