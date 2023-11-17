from py_testgen_app.src.Copilot.QuickSort.PromptOnly.T7.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort(self):
        # Test case 1
        # Test input: [1, 2, 3]
        # Expected output: [1, 2, 3]
        # Actual output: [1, 2, 3]
        # Test result: PASS
        self.assertEqual(QuickSort.sort([1, 2, 3]), [1, 2, 3])

    def test_sort(self):
        # Test case 2
        # Test input: [4, 3, 2, 1]
        # Expected output: [1, 2, 3, 4]
        # Actual output: [1, 2, 3, 4]
        # Test result: PASS
        self.assertEqual(QuickSort.sort([4, 3, 2, 1]), [1, 2, 3, 4])

    def test_sort(self):
        # Test case 3
        # Test input: [1, 2, 3, 4]
        # Expected output: [1, 2, 3, 4]
        # Actual output: [1, 2, 3, 4]
        # Test result: PASS
        self.assertEqual(QuickSort.sort([1, 2, 3, 4]), [1, 2, 3, 4])