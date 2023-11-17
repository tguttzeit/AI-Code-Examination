class BinarySearch:

    def binary_search(self, search_number, sorted_list):
        first = 0
        last = len(sorted_list) - 1
        found = False

        while first <= last and not found:
            midpoint = (first + last) // 2
            if sorted_list[midpoint] == search_number:
                found = True
            else:
                if search_number < sorted_list[midpoint]:
                    last = midpoint - 1
                else:
                    first = midpoint + 1

        return found
