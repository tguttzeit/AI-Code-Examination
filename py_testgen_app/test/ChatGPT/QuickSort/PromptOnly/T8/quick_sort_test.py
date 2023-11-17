from py_testgen_app.src.ChatGPT.QuickSort.PromptOnly.T8.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort_empty_list(self):
        sorter = QuickSort()
        input_list = []
        sorter.sort(input_list)
        self.assertEqual(input_list, [], "Sorting an empty list should result in an empty list")

    def test_sort_sorted_list(self):
        sorter = QuickSort()
        input_list = [1, 2, 3, 4, 5]
        expected_output = [1, 2, 3, 4, 5]
        sorter.sort(input_list)
        self.assertEqual(input_list, expected_output, "Sorting an already sorted list should result in the same list")

    def test_sort_reverse_sorted_list(self):
        sorter = QuickSort()
        input_list = [5, 4, 3, 2, 1]
        expected_output = [1, 2, 3, 4, 5]
        sorter.sort(input_list)
        self.assertEqual(input_list, expected_output, "Sorting a reverse-sorted list should result in a sorted list")
