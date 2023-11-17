from py_testgen_app.src.ChatGPT.MergeSort.BookExampleCode.T1.merge_sort import MergeSort

import unittest

class TestMergeSort(unittest.TestCase):

    def setUp(self):
        # Create an instance of the MergeSort class
        self.merge_sort = MergeSort()

    def test_empty_list(self):
        # Test sorting an empty list
        unsorted_list = []
        sorted_list = self.merge_sort.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [])

    def test_sorted_list(self):
        # Test sorting a list that is already sorted
        unsorted_list = [1, 2, 3, 4, 5]
        sorted_list = self.merge_sort.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])

    def test_reverse_sorted_list(self):
        # Test sorting a list in reverse order
        unsorted_list = [5, 4, 3, 2, 1]
        sorted_list = self.merge_sort.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])

    def test_random_order_list(self):
        # Test sorting a list in random order
        unsorted_list = [3, 1, 4, 5, 2]
        sorted_list = self.merge_sort.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [1, 2, 3, 4, 5])