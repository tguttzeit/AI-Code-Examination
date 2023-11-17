class BinarySearch:
    def binary_search(self, target, arr):
        """
        Perform binary search on a sorted integer list.

        Args:
            target (int): The target integer to search for.
            arr (list): A sorted list of integers.

        Returns:
            bool: True if the target is found in the list, False otherwise.
        """
        left, right = 0, len(arr) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if arr[mid] == target:
                return True  # Target found
            elif arr[mid] < target:
                left = mid + 1
            else:
                right = mid - 1

        return False  # Target not found
