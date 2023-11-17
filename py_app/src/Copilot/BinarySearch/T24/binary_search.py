class BinarySearch:

    def binary_search(self, item, item_list):
        first = 0
        last = len(item_list) - 1
        found = False

        while first <= last and not found:
            midpoint = (first + last) // 2
            if item_list[midpoint] == item:
                found = True
            else:
                if item < item_list[midpoint]:
                    last = midpoint - 1
                else:
                    first = midpoint + 1

        return found
