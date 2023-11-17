from py_testgen_app.src.ChatGPT.QuickSort.PromptOnly.T7.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort_empty_list(self):
        # Test sorting an empty list
        input_list = []
        expected_output = []
        quick_sort = QuickSort()
        quick_sort.sort(input_list)
        self.assertEqual(input_list, expected_output)

    def test_sort_sorted_list(self):
        # Test sorting an already sorted list
        input_list = [1, 2, 3, 4, 5]
        expected_output = [1, 2, 3, 4, 5]
        quick_sort = QuickSort()
        quick_sort.sort(input_list)
        self.assertEqual(input_list, expected_output)

    def test_sort_reverse_sorted_list(self):
        # Test sorting a reverse sorted list
        input_list = [5, 4, 3, 2, 1]
        expected_output = [1, 2, 3, 4, 5]
        quick_sort = QuickSort()
        quick_sort.sort(input_list)
        self.assertEqual(input_list, expected_output)