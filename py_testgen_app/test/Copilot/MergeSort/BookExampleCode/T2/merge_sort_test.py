from py_testgen_app.src.Copilot.MergeSort.BookExampleCode.T2.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort(self):
        merge_sort = MergeSort()
        self.assertEqual(merge_sort.merge_sort([3, 5, 1, 2, 9]), [1, 2, 3, 5, 9])
        self.assertEqual(merge_sort.merge_sort([5, 3, 1, 2, 9, 4, 8, 7, 6]), [1, 2, 3, 4, 5, 6, 7, 8, 9])
        self.assertEqual(merge_sort.merge_sort([5, 3, 1, 2, 9, 4, 8, 7, 6, 0]), [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
