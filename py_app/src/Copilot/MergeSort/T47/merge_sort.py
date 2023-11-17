class MergeSort:
    def merge_sort(self, data):
        if len(data) <= 1:
            return data

        middle_index = len(data) // 2
        left_data = self.merge_sort(data[:middle_index])
        right_data = self.merge_sort(data[middle_index:])

        return self.merge(left_data, right_data)

    def merge(self, left_data, right_data):
        sorted_list = []
        left_index = right_index = 0

        while left_index < len(left_data) and right_index < len(right_data):
            if left_data[left_index] < right_data[right_index]:
                sorted_list.append(left_data[left_index])
                left_index += 1
            else:
                sorted_list.append(right_data[right_index])
                right_index += 1

        sorted_list += left_data[left_index:]
        sorted_list += right_data[right_index:]

        return sorted_list
