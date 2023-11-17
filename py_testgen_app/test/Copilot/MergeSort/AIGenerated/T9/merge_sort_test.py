from py_testgen_app.src.Copilot.MergeSort.AIGenerated.T9.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def setUp(self):
        self.mergesort = MergeSort()

    def test_merge_sort(self):
        self.assertEqual(self.mergesort.merge_sort([2, 3, 1, 4]), [1, 2, 3, 4])
        self.assertEqual(self.mergesort.merge_sort([1, 3, 2, 4, 5, 6, 8, 7]), [1, 2, 3, 4, 5, 6, 7, 8])
        self.assertEqual(self.mergesort.merge_sort([1]), [1])
