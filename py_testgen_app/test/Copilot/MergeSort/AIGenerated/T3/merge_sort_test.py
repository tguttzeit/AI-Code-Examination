from py_testgen_app.src.Copilot.MergeSort.AIGenerated.T3.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def setUp(self):
        self.merge_sort = MergeSort()

    def test_merge_sort(self):
        self.assertEqual(self.merge_sort.merge_sort([1, 2, 3, 4, 5, 6]), [1, 2, 3, 4, 5, 6])
        self.assertEqual(self.merge_sort.merge_sort([6, 5, 4, 3, 2, 1]), [1, 2, 3, 4, 5, 6])
        self.assertEqual(self.merge_sort.merge_sort([1, 3, 2, 4, 5]), [1, 2, 3, 4, 5])
        self.assertEqual(self.merge_sort.merge_sort([1]), [1])
        self.assertEqual(self.merge_sort.merge_sort([]), [])
