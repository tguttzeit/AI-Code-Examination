from py_testgen_app.src.Copilot.MergeSort.AIGenerated.T4.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def setUp(self):
        self.merge_sort = MergeSort()

    def test_merge_sort(self):
        self.assertEqual(self.merge_sort.merge_sort([1, 5, 3, 2, 4]), [1, 2, 3, 4, 5])
        self.assertEqual(self.merge_sort.merge_sort([1, 5, 3, 2, 4, 6]), [1, 2, 3, 4, 5, 6])
        self.assertEqual(self.merge_sort.merge_sort([1, 5, 3, 2, 4, 6, 7]), [1, 2, 3, 4, 5, 6, 7])
