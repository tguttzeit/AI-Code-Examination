from py_testgen_app.src.ChatGPT.MergeSort.BookExampleCode.T7.merge_sort import MergeSort

import unittest

class TestMergeSort(unittest.TestCase):
    def setUp(self):
        self.merge_sorter = MergeSort()

    def test_empty_list(self):
        input_list = []
        result = self.merge_sorter.merge_sort(input_list)
        self.assertEqual(result, [])

    def test_sorted_list(self):
        input_list = [1, 2, 3, 4, 5]
        result = self.merge_sorter.merge_sort(input_list)
        self.assertEqual(result, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        input_list = [5, 4, 3, 2, 1]
        result = self.merge_sorter.merge_sort(input_list)
        self.assertEqual(result, [1, 2, 3, 4, 5])

    def test_random_order_list(self):
        input_list = [3, 1, 4, 2, 5]
        result = self.merge_sorter.merge_sort(input_list)
        self.assertEqual(result, [1, 2, 3, 4, 5])

