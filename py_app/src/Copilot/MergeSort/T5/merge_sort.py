class MergeSort:
    def merge_sort(self, list_to_sort):
        if len(list_to_sort) <= 1:
            return list_to_sort

        middle = len(list_to_sort) // 2
        left_list = list_to_sort[:middle]
        right_list = list_to_sort[middle:]

        left_list = self.merge_sort(left_list)
        right_list = self.merge_sort(right_list)

        return self.merge(left_list, right_list)

    def merge(self, left_list, right_list):
        sorted_list = []
        left_list_index = right_list_index = 0

        # We use the list lengths often, so it's handy to make variables
        left_list_length, right_list_length = len(left_list), len(right_list)

        for _ in range(left_list_length + right_list_length):
            if left_list_index < left_list_length and right_list_index < right_list_length:
                # We check which value from the start of each list is smaller
                # If the item at the beginning of the left list is smaller, add it
                # to the sorted list
                if left_list[left_list_index] <= right_list[right_list_index]:
                    sorted_list.append(left_list[left_list_index])
                    left_list_index += 1
                # If the item at the beginning of the right list is smaller, add it
                # to the sorted list
                else:
                    sorted_list.append(right_list[right_list_index])
                    right_list_index += 1

            # If we've reached the end of the of the left list, add the elements
            # from the right list
            elif left_list_index == left_list_length:
                sorted_list.append(right_list[right_list_index])
                right_list_index += 1
            # If we've reached the end of the of the right list, add the elements
            # from the left list
            elif right_list_index == right_list_length:
                sorted_list.append(left_list[left_list_index])
                left_list_index += 1

        return sorted_list
