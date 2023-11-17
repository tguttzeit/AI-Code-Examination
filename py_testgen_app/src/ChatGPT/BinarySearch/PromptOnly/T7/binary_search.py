# Source: https://github.com/PacktPublishing/Hands-On-Data-Structures-and-Algorithms-with-Python-Third-Edition/blob
# /main/Chapter02/binary_search.py

# CHANGE FOR EXPERIMENT: This class got refactored due to the requirements of the test class.
class BinarySearch:

    # CHANGE FOR EXPERIMENT: The original name of this method in the source was "search()"
    def binary_search(self, key, arr):
        low = 0
        high = len(arr) - 1

        while low <= high:
            mid = int(low + (high - low) / 2)
            if arr[mid] == key:
                return True
            elif arr[mid] < key:
                low = mid + 1
            else:
                high = mid - 1
        return False
