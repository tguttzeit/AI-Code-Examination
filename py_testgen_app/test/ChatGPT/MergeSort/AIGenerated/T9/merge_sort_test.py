from py_testgen_app.src.ChatGPT.MergeSort.AIGenerated.T9.merge_sort import MergeSort

import unittest

class TestMergeSort(unittest.TestCase):
    def setUp(self):
        self.merge_sorter = MergeSort()

    def test_empty_list(self):
        arr = []
        sorted_arr = self.merge_sorter.merge_sort(arr)
        self.assertEqual(sorted_arr, [])

    def test_sorted_list(self):
        arr = [1, 2, 3, 4, 5]
        sorted_arr = self.merge_sorter.merge_sort(arr)
        self.assertEqual(sorted_arr, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        arr = [5, 4, 3, 2, 1]
        sorted_arr = self.merge_sorter.merge_sort(arr)
        self.assertEqual(sorted_arr, [1, 2, 3, 4, 5])

    def test_random_order_list(self):
        arr = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        sorted_arr = self.merge_sorter.merge_sort(arr)
        self.assertEqual(sorted_arr, [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9])
