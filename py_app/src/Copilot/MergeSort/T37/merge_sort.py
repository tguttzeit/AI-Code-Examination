class MergeSort:
    def __init__(self):
        pass

    def merge_sort(self, list):
        if len(list) <= 1:
            return list

        middle = len(list) // 2
        left_list = list[:middle]
        right_list = list[middle:]

        left_list = self.merge_sort(left_list)
        right_list = self.merge_sort(right_list)
        return self.merge(left_list, right_list)

    def merge(self, left_list, right_list):
        sorted_list = []
        left_list_index = right_list_index = 0

        left_list_length, right_list_length = len(left_list), len(right_list)

        for _ in range(left_list_length + right_list_length):
            if left_list_index < left_list_length and right_list_index < right_list_length:
                if left_list[left_list_index] <= right_list[right_list_index]:
                    sorted_list.append(left_list[left_list_index])
                    left_list_index += 1
                else:
                    sorted_list.append(right_list[right_list_index])
                    right_list_index += 1

            elif left_list_index == left_list_length:
                sorted_list.append(right_list[right_list_index])
                right_list_index += 1
            elif right_list_index == right_list_length:
                sorted_list.append(left_list[left_list_index])
                left_list_index += 1

        return sorted_list
