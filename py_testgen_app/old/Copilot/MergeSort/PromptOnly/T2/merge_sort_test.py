from py_testgen_app.src.Copilot.MergeSort.PromptOnly.T2.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort(self):
        # Test case 1
        # Input: [1, 2, 3, 4]
        # Expected output: [1, 2, 3, 4]
        self.assertEqual(MergeSort.merge_sort([1, 2, 3, 4]), [1, 2, 3, 4])

        # Test case 2
        # Input: [4, 3, 2, 1]
        # Expected output: [1, 2, 3, 4]
        self.assertEqual(MergeSort.merge_sort([4, 3, 2, 1]), [1, 2, 3, 4])

        # Test case 3
        # Input: [1, 5, 2, 4, 3]
        # Expected output: [1, 2, 3, 4, 5]
        self.assertEqual(MergeSort.merge_sort([1, 5, 2, 4, 3]), [1, 2, 3, 4, 5])
