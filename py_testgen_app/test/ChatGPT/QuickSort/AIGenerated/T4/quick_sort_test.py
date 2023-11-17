from py_testgen_app.src.ChatGPT.QuickSort.AIGenerated.T4.quick_sort import QuickSort

import unittest

class TestQuickSort(unittest.TestCase):
    def setUp(self):
        self.quick_sort = QuickSort()

    def test_empty_list(self):
        input_list = []
        self.quick_sort.sort(input_list)
        self.assertEqual(input_list, [])

    def test_sorted_list(self):
        input_list = [1, 2, 3, 4, 5]
        expected_output = [1, 2, 3, 4, 5]
        self.quick_sort.sort(input_list)
        self.assertEqual(input_list, expected_output)

    def test_reverse_sorted_list(self):
        input_list = [5, 4, 3, 2, 1]
        expected_output = [1, 2, 3, 4, 5]
        self.quick_sort.sort(input_list)
        self.assertEqual(input_list, expected_output)

    def test_random_list(self):
        input_list = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        expected_output = [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9]
        self.quick_sort.sort(input_list)
        self.assertEqual(input_list, expected_output)
