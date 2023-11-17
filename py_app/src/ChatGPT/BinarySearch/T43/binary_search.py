class BinarySearch:
    def binary_search(self, target, arr):
        left, right = 0, len(arr) - 1

        while left <= right:
            mid = left + (right - left) // 2  # Calculate the middle index

            if arr[mid] == target:  # Check if the middle element is the target
                return True
            elif arr[mid] < target:  # If target is greater, search the right half
                left = mid + 1
            else:  # If target is smaller, search the left half
                right = mid - 1

        return False  # Target not found in the list
