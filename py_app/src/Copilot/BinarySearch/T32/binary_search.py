class BinarySearch:

    def binary_search(self, item, array):
        if len(array) == 0:
            return False
        else:
            midpoint = len(array) // 2
            if array[midpoint] == item:
                return True
            else:
                if item < array[midpoint]:
                    return self.binary_search(item, array[:midpoint])
                else:
                    return self.binary_search(item, array[midpoint + 1:])
