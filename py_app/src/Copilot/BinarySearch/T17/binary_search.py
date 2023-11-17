class BinarySearch:

    def binary_search(self, number, sorted_list):
        if len(sorted_list) == 0:
            return False
        else:
            mid = len(sorted_list) // 2
            if sorted_list[mid] == number:
                return True
            elif sorted_list[mid] > number:
                return self.binary_search(number, sorted_list[:mid])
            else:
                return self.binary_search(number, sorted_list[mid+1:])
