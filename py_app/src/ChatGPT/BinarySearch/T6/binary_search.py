class BinarySearch:
    def __init__(self, sorted_list):
        self.sorted_list = sorted_list

    def binary_search(self, target):
        left, right = 0, len(self.sorted_list) - 1

        while left <= right:
            mid = left + (right - left) // 2  # Calculate the middle index

            if self.sorted_list[mid] == target:
                return True  # Found the target
            elif self.sorted_list[mid] < target:
                left = mid + 1  # Target is in the right half
            else:
                right = mid - 1  # Target is in the left half

        return False  # Target not found in the list
