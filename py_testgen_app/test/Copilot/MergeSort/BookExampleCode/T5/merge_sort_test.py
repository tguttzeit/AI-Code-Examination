from py_testgen_app.src.Copilot.MergeSort.BookExampleCode.T5.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort(self):
        merge_sort = MergeSort()
        self.assertEqual(merge_sort.merge_sort([1, 2, 3, 4, 5, 6]), [1, 2, 3, 4, 5, 6])
        self.assertEqual(merge_sort.merge_sort([6, 5, 4, 3, 2, 1]), [1, 2, 3, 4, 5, 6])
        self.assertEqual(merge_sort.merge_sort([1, 3, 2, 4, 5, 6]), [1, 2, 3, 4, 5, 6])
