from py_testgen_app.src.ChatGPT.MergeSort.BookExampleCode.T2.merge_sort import MergeSort

import unittest

class TestMergeSort(unittest.TestCase):
    def setUp(self):
        self.mergesort = MergeSort()

    def test_empty_list(self):
        unsorted_list = []
        sorted_list = self.mergesort.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [])

    def test_sorted_list(self):
        unsorted_list = [1, 2, 3, 4, 5]
        sorted_list = self.mergesort.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        unsorted_list = [5, 4, 3, 2, 1]
        sorted_list = self.mergesort.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])

    def test_random_list(self):
        unsorted_list = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
        sorted_list = self.mergesort.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9])
