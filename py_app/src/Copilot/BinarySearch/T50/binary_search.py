class BinarySearch:

    def binary_search(self, key, list):
        low = 0
        high = len(list) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if key < list[mid]:
                high = mid - 1
            elif key > list[mid]:
                low = mid + 1
            else:
                return True
        return False
