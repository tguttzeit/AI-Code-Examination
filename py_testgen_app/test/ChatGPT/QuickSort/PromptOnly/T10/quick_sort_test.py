from py_testgen_app.src.ChatGPT.QuickSort.PromptOnly.T10.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_empty_list(self):
        # Test sorting an empty list
        input_list = []
        expected_result = []
        quick_sort = QuickSort()
        quick_sort.sort(input_list)
        self.assertEqual(input_list, expected_result)

    def test_sorted_list(self):
        # Test sorting an already sorted list
        input_list = [1, 2, 3, 4, 5]
        expected_result = [1, 2, 3, 4, 5]
        quick_sort = QuickSort()
        quick_sort.sort(input_list)
        self.assertEqual(input_list, expected_result)

    def test_reverse_sorted_list(self):
        # Test sorting a reverse sorted list
        input_list = [5, 4, 3, 2, 1]
        expected_result = [1, 2, 3, 4, 5]
        quick_sort = QuickSort()
        quick_sort.sort(input_list)
        self.assertEqual(input_list, expected_result)