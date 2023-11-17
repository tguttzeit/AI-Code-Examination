from py_testgen_app.src.Copilot.MergeSort.AIGenerated.T6.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort(self):
        merge_sort = MergeSort()
        self.assertEqual(merge_sort.merge_sort([1, 2, 3, 4, 5]), [1, 2, 3, 4, 5])
        self.assertEqual(merge_sort.merge_sort([5, 4, 3, 2, 1]), [1, 2, 3, 4, 5])
        self.assertEqual(merge_sort.merge_sort([1, 3, 2, 5, 4]), [1, 2, 3, 4, 5])
