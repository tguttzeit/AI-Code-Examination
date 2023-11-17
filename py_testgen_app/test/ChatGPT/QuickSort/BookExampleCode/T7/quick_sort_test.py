from py_testgen_app.src.ChatGPT.QuickSort.BookExampleCode.T7.quick_sort import QuickSort

import unittest

class TestQuickSort(unittest.TestCase):
    def setUp(self):
        self.quick_sort = QuickSort()

    def test_sort_empty_list(self):
        input_array = []
        expected_output = []
        self.quick_sort.sort(input_array)
        self.assertEqual(input_array, expected_output)

    def test_sort_sorted_list(self):
        input_array = [1, 2, 3, 4, 5]
        expected_output = [1, 2, 3, 4, 5]
        self.quick_sort.sort(input_array)
        self.assertEqual(input_array, expected_output)

    def test_sort_reverse_sorted_list(self):
        input_array = [5, 4, 3, 2, 1]
        expected_output = [1, 2, 3, 4, 5]
        self.quick_sort.sort(input_array)
        self.assertEqual(input_array, expected_output)

    def test_sort_random_list(self):
        input_array = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        expected_output = [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9]
        self.quick_sort.sort(input_array)
        self.assertEqual(input_array, expected_output)