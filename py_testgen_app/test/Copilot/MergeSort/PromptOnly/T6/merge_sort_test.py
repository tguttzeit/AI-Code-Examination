from py_testgen_app.src.Copilot.MergeSort.PromptOnly.T6.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort_1(self):
        self.assertEqual(MergeSort().merge_sort([1, 2, 3]), [1, 2, 3])

    def test_merge_sort_2(self):
        self.assertEqual(MergeSort().merge_sort([3, 2, 1]), [1, 2, 3])

    def test_merge_sort_3(self):
        self.assertEqual(MergeSort().merge_sort([3, 1, 2]), [1, 2, 3])
