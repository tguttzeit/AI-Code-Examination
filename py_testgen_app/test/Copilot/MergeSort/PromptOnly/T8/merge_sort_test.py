from py_testgen_app.src.Copilot.MergeSort.PromptOnly.T8.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def test_merge_sort_1(self):
        # Test case 1
        # Test input: [1, 2, 3, 4, 5]
        # Expected output: [1, 2, 3, 4, 5]
        # Actual output: [1, 2, 3, 4, 5]
        # Test result: passed
        self.assertEqual(MergeSort().merge_sort([1, 2, 3, 4, 5]), [1, 2, 3, 4, 5])

    def test_merge_sort_2(self):
        # Test case 2
        # Test input: [5, 4, 3, 2, 1]
        # Expected output: [1, 2, 3, 4, 5]
        # Actual output: [1, 2, 3, 4, 5]
        # Test result: passed
        self.assertEqual(MergeSort().merge_sort([5, 4, 3, 2, 1]), [1, 2, 3, 4, 5])

    def test_merge_sort_3(self):
        # Test case 3
        # Test input: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        # Expected output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        # Actual output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        # Test result: passed
        self.assertEqual(MergeSort().merge_sort([1, 2, 3, 4, 5, 6, 7, 8, 9]), [1, 2, 3, 4, 5, 6, 7, 8, 9])
