from py_testgen_app.src.Copilot.MergeSort.PromptOnly.T7.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort(self):
        # Test Case 1
        # Input: [5, 2, 4, 6, 1, 3]
        # Expected Output: [1, 2, 3, 4, 5, 6]
        # Actual Output: [1, 2, 3, 4, 5, 6]
        self.assertEqual(MergeSort.merge_sort([5, 2, 4, 6, 1, 3]), [1, 2, 3, 4, 5, 6])

        # Test Case 2
        # Input: [31, 41, 59, 26, 41, 58]
        # Expected Output: [26, 31, 41, 41, 58, 59]
        # Actual Output: [26, 31, 41, 41, 58, 59]
        self.assertEqual(MergeSort.merge_sort([31, 41, 59, 26, 41, 58]), [26, 31, 41, 41, 58, 59])

        # Test Case 3
        # Input: [1, 2, 3, 4, 5, 6]
        # Expected Output: [1, 2, 3, 4, 5, 6]
        # Actual Output: [1, 2, 3, 4, 5, 6]
        self.assertEqual(MergeSort.merge_sort([1, 2, 3, 4, 5, 6]), [1, 2, 3, 4, 5, 6])
