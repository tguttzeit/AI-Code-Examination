class BinarySearch:

    def binary_search(self, search_value, sorted_values):
        if len(sorted_values) == 0:
            return False
        else:
            mid_point = len(sorted_values) // 2
            if sorted_values[mid_point] == search_value:
                return True
            else:
                if search_value < sorted_values[mid_point]:
                    return self.binary_search(search_value, sorted_values[:mid_point])
                else:
                    return self.binary_search(search_value, sorted_values[mid_point + 1:])
