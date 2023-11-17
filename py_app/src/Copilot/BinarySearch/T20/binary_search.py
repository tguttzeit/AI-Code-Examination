class BinarySearch:

    def __init__(self):
        pass

    def binary_search(self, search_item, sorted_list):
        if len(sorted_list) == 0:
            return False
        else:
            mid = len(sorted_list) // 2
            if sorted_list[mid] == search_item:
                return True
            else:
                if search_item < sorted_list[mid]:
                    return self.binary_search(search_item, sorted_list[:mid])
                else:
                    return self.binary_search(search_item, sorted_list[mid + 1:])
