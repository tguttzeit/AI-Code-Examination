class BinarySearch:

    def binary_search(self, val, list):
        if len(list) == 0:
            return False
        else:
            mid = len(list) // 2
            if list[mid] == val:
                return True
            else:
                if val < list[mid]:
                    return self.binary_search(val, list[:mid])
                else:
                    return self.binary_search(val, list[mid + 1:])
