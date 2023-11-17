
class BinarySearch:
    def binary_search(self, value, array):
        if len(array) == 0:
            return False
        else:
            mid = len(array) // 2
            if array[mid] == value:
                return True
            elif array[mid] > value:
                return self.binary_search(value, array[:mid])
            else:
                return self.binary_search(value, array[mid + 1:])