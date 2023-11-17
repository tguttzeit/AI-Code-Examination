class BinarySearch:

    def binary_search(self, value, list):
        low = 0
        high = len(list) - 1
        while low <= high:
            mid = (low + high) // 2
            if list[mid] < value:
                low = mid + 1
            elif list[mid] > value:
                high = mid - 1
            else:
                return True
        return False
