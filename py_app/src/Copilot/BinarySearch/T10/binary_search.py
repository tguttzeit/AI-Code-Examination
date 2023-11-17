class BinarySearch:
    def binary_search(self, list, key):
        if len(list) == 0:
            return False
        else:
            mid = len(list) // 2
            if list[mid] == key:
                return True
            else:
                if key < list[mid]:
                    return self.binary_search(list[:mid], key)
                else:
                    return self.binary_search(list[mid + 1:], key)
