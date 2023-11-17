class BinarySearch:

    def binary_search(self, target, data):
        data.sort()
        low = 0
        high = len(data) - 1
        while low <= high:
            mid = (low + high) // 2
            if target == data[mid]:
                return True
            elif target < data[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return False
