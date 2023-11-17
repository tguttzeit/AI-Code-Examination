from py_testgen_app.src.ChatGPT.MergeSort.BookExampleCode.T8.merge_sort import MergeSort

import unittest

class TestMergeSort(unittest.TestCase):
    def setUp(self):
        self.merge_sorter = MergeSort()

    def test_empty_list(self):
        unsorted_list = []
        sorted_list = self.merge_sorter.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [])

    def test_sorted_list(self):
        unsorted_list = [1, 2, 3, 4, 5]
        sorted_list = self.merge_sorter.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        unsorted_list = [5, 4, 3, 2, 1]
        sorted_list = self.merge_sorter.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])

    def test_random_list(self):
        unsorted_list = [3, 1, 4, 2, 5]
        sorted_list = self.merge_sorter.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])
