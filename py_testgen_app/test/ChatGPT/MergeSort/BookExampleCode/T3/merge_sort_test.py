from py_testgen_app.src.ChatGPT.MergeSort.BookExampleCode.T3.merge_sort import MergeSort

import unittest

class TestMergeSort(unittest.TestCase):
    def setUp(self):
        self.sorter = MergeSort()

    def test_merge_sort_empty_list(self):
        input_list = []
        result = self.sorter.merge_sort(input_list)
        self.assertEqual(result, [])

    def test_merge_sort_sorted_list(self):
        input_list = [1, 2, 3, 4, 5]
        result = self.sorter.merge_sort(input_list)
        self.assertEqual(result, [1, 2, 3, 4, 5])

    def test_merge_sort_reverse_sorted_list(self):
        input_list = [5, 4, 3, 2, 1]
        result = self.sorter.merge_sort(input_list)
        self.assertEqual(result, [1, 2, 3, 4, 5])

    def test_merge_sort_random_list(self):
        input_list = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        result = self.sorter.merge_sort(input_list)
        self.assertEqual(result, [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9])
