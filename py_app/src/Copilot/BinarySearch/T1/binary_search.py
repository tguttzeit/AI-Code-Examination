class BinarySearch:
    def binary_search(self, value, list):
        if len(list) == 0:
            return False
        else:
            midpoint = len(list) // 2
            if list[midpoint] == value:
                return True
            else:
                if value < list[midpoint]:
                    return self.binary_search(value, list[:midpoint])
                else:
                    return self.binary_search(value, list[midpoint + 1 :])

