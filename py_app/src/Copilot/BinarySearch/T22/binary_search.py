class BinarySearch:

    def binary_search(self, value, input_list):
        if len(input_list) == 0:
            return False
        else:
            mid = len(input_list) // 2
            if input_list[mid] == value:
                return True
            else:
                if value < input_list[mid]:
                    return self.binary_search(value, input_list[:mid])
                else:
                    return self.binary_search(value, input_list[mid + 1:])
