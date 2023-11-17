class BinarySearch:

    def binary_search(self, value, arr):
        if len(arr) == 0:
            return False

        mid = len(arr) // 2
        if value == arr[mid]:
            return True
        elif value < arr[mid]:
            return self.binary_search(value, arr[:mid])
        else:
            return self.binary_search(value, arr[mid + 1:])
