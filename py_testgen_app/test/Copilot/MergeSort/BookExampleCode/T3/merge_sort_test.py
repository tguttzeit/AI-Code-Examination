from py_testgen_app.src.Copilot.MergeSort.BookExampleCode.T3.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort(self):
        merge_sort = MergeSort()
        self.assertEqual(merge_sort.merge_sort([3, 2, 1]), [1, 2, 3])
        self.assertEqual(merge_sort.merge_sort([4, 2, 1, 3]), [1, 2, 3, 4])
        self.assertEqual(merge_sort.merge_sort([1, 2, 3, 4]), [1, 2, 3, 4])
