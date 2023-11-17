from py_testgen_app.src.Copilot.MergeSort.BookExampleCode.T1.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def setUp(self):
        self.merge_sort = MergeSort()

    def test_merge_sort(self):
        self.assertEqual(self.merge_sort.merge_sort([1, 3, 5, 7, 9, 2, 4, 6, 8, 10]), [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
        self.assertEqual(self.merge_sort.merge_sort([1, 3, 5, 7, 9, 2, 4, 6, 8]), [1, 2, 3, 4, 5, 6, 7, 8, 9])
        self.assertEqual(self.merge_sort.merge_sort([1, 3, 5, 7, 9, 2, 4, 6]), [1, 2, 3, 4, 5, 6, 7, 9])
        self.assertEqual(self.merge_sort.merge_sort([1, 3, 5, 7, 9, 2, 4]), [1, 2, 3, 4, 5, 7, 9])
