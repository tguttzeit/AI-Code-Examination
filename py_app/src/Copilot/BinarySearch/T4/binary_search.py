class BinarySearch:
    def binary_search(self, element, sorted_list):
        if not sorted_list:
            return False

        mid = len(sorted_list) // 2
        if element == sorted_list[mid]:
            return True
        elif element < sorted_list[mid]:
            return self.binary_search(element, sorted_list[:mid])
        else:
            return self.binary_search(element, sorted_list[mid + 1:])