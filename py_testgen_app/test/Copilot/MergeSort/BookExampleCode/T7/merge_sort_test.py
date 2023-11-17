from py_testgen_app.src.Copilot.MergeSort.BookExampleCode.T7.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def setUp(self):
        self.mergesort = MergeSort()

    def test_merge_sort(self):
        self.assertEqual(self.mergesort.merge_sort([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]), [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
        self.assertEqual(self.mergesort.merge_sort([10, 9, 8, 7, 6, 5, 4, 3, 2, 1]), [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
        self.assertEqual(self.mergesort.merge_sort([1, 5, 2, 4, 3, 6, 7, 9, 8, 10]), [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
