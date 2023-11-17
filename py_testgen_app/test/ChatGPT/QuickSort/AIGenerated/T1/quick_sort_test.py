from py_testgen_app.src.ChatGPT.QuickSort.AIGenerated.T1.quick_sort import QuickSort

import unittest

class TestQuickSort(unittest.TestCase):
    def setUp(self):
        self.sorter = QuickSort()

    def test_empty_list(self):
        input_list = []
        expected_output = []
        self.sorter.sort(input_list)
        self.assertEqual(input_list, expected_output)

    def test_sorted_list(self):
        input_list = [1, 2, 3, 4, 5]
        expected_output = [1, 2, 3, 4, 5]
        self.sorter.sort(input_list)
        self.assertEqual(input_list, expected_output)

    def test_reverse_sorted_list(self):
        input_list = [5, 4, 3, 2, 1]
        expected_output = [1, 2, 3, 4, 5]
        self.sorter.sort(input_list)
        self.assertEqual(input_list, expected_output)
