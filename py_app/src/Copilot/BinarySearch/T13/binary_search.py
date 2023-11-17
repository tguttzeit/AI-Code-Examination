class BinarySearch:

    def binary_search(self, list, item):
        low = 0
        high = len(list) - 1

        while low <= high:
            mid = (low + high) // 2

            if list[mid] == item:
                return True
            elif list[mid] > item:
                high = mid - 1
            else:
                low = mid + 1

        return False
