class BinarySearch:
    def binary_search(self, target, arr):
        left, right = 0, len(arr) - 1

        while left <= right:
            mid = left + (right - left) // 2  # Calculate the middle index
            mid_element = arr[mid]  # Get the middle element

            if mid_element == target:
                return True  # Found the target
            elif mid_element < target:
                left = mid + 1  # Target is in the right half
            else:
                right = mid - 1  # Target is in the left half

        return False  # Target not found in the list
