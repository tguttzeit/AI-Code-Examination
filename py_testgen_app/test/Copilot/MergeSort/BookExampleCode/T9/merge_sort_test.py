from py_testgen_app.src.Copilot.MergeSort.BookExampleCode.T9.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort(self):
        merge_sort = MergeSort()
        unsorted_list = [5, 1, 7, 2, 6, -3, -2]
        sorted_list = merge_sort.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [-3, -2, 1, 2, 5, 6, 7])

    def test_merge_sort_empty_list(self):
        merge_sort = MergeSort()
        unsorted_list = []
        sorted_list = merge_sort.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [])

    def test_merge_sort_one_element_list(self):
        merge_sort = MergeSort()
        unsorted_list = [1]
        sorted_list = merge_sort.merge_sort(unsorted_list)
        self.assertEqual(sorted_list, [1])
