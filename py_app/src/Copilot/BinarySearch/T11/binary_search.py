class BinarySearch:

    # Implement the binary_search() method.
    def binary_search(self, key, items):
        low = 0
        high = len(items) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if key < items[mid]:
                high = mid - 1
            elif key > items[mid]:
                low = mid + 1
            else:
                return True

        return False
