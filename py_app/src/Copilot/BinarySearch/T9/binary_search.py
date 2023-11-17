class BinarySearch:
    def binary_search(self, key, arr):
        if len(arr) == 0:
            return False
        else:
            mid = len(arr) // 2
            if arr[mid] == key:
                return True
            else:
                if arr[mid] > key:
                    return self.binary_search(key, arr[:mid])
                else:
                    return self.binary_search(key, arr[mid + 1:])
