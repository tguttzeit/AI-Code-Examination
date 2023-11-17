class BinarySearch:
    def binary_search(self, target, arr):
        # Initialize left and right pointers
        left, right = 0, len(arr) - 1

        while left <= right:
            mid = left + (right - left) // 2  # Calculate the middle index

            if arr[mid] == target:
                return True  # Target element found
            elif arr[mid] < target:
                left = mid + 1  # Adjust the left pointer
            else:
                right = mid - 1  # Adjust the right pointer

        return False  # Target element not found
