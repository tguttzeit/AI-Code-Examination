from py_testgen_app.src.Copilot.MergeSort.PromptOnly.T3.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort_1(self):
        # Test case 1
        # Input: merge_sort([3, 2, 5, 4, 1])
        # Expected Output: [1, 2, 3, 4, 5]
        self.assertEqual(MergeSort().merge_sort([3, 2, 5, 4, 1]), [1, 2, 3, 4, 5])

    def test_merge_sort_2(self):
        # Test case 2
        # Input: merge_sort([1, 2, 3, 4, 5])
        # Expected Output: [1, 2, 3, 4, 5]
        self.assertEqual(MergeSort().merge_sort([1, 2, 3, 4, 5]), [1, 2, 3, 4, 5])

    def test_merge_sort_3(self):
        # Test case 3
        # Input: merge_sort([5, 4, 3, 2, 1])
        # Expected Output: [1, 2, 3, 4, 5]
        self.assertEqual(MergeSort().merge_sort([5, 4, 3, 2, 1]), [1, 2, 3, 4, 5])
