class BinarySearch:

    def binary_search(self, value, list):
        low = 0
        high = len(list) - 1

        while low <= high:
            middle = (low + high) // 2

            if list[middle] == value:
                return True
            elif list[middle] < value:
                low = middle + 1
            else:
                high = middle - 1

        return False
