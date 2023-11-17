
class BinarySearch:
    def binary_search(self, value, list):
        return self.binary_search_helper(value, list, 0, len(list) - 1)

    def binary_search_helper(self, value, list, low, high):
        if low > high:
            return False
        mid = (low + high) // 2
        if list[mid] == value:
            return True
        elif list[mid] < value:
            return self.binary_search_helper(value, list, mid + 1, high)
        else:
            return self.binary_search_helper(value, list, low, mid - 1)
