class BinarySearch:

    def binary_search(self, search_value: int, values: list) -> bool:
        if len(values) == 0:
            return False
        else:
            mid = len(values) // 2
            if values[mid] == search_value:
                return True
            elif values[mid] < search_value:
                return self.binary_search(search_value, values[mid + 1:])
            else:
                return self.binary_search(search_value, values[:mid])
