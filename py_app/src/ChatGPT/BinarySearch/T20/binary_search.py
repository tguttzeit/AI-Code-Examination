class BinarySearch:
    def __init__(self):
        pass

    def binary_search(self, target, arr):
        left, right = 0, len(arr) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if arr[mid] == target:
                return True
            elif arr[mid] < target:
                left = mid + 1
            else:
                right = mid - 1

        return False
