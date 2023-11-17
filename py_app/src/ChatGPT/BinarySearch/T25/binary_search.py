class BinarySearch:
    def binary_search(self, target, arr):
        # Initialize the left and right pointers
        left, right = 0, len(arr) - 1

        while left <= right:
            # Calculate the middle index
            mid = left + (right - left) // 2

            # Check if the middle element is equal to the target
            if arr[mid] == target:
                return True  # Target found

            # If the target is smaller, search in the left half
            elif arr[mid] > target:
                right = mid - 1

            # If the target is larger, search in the right half
            else:
                left = mid + 1

        return False  # Target not found
