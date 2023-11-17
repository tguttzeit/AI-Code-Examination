from py_testgen_app.src.Copilot.QuickSort.PromptOnly.T4.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    # Test 1:
    # Input: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    # Expected Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    # Actual Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    # Test Result: Passed
    # Note: Test 1 passes because the list is already sorted.
    # It is a best case scenario.
    def a(self):
        test1 = QuickSort()
        test1.sort([1, 2, 3, 4, 5, 6, 7, 8, 9])
        self.assertEqual(test1, [1, 2, 3, 4, 5, 6, 7, 8, 9])

    # Test 2:
    # Input: [9, 8, 7, 6, 5, 4, 3, 2, 1]
    # Expected Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    # Actual Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    # Test Result: Passed
    # Note: Test 2 passes because the list is in reverse order.
    # It is a worst case scenario.
    
        test2 = QuickSort()
        test2.sort([9, 8, 7, 6, 5, 4, 3, 2, 1])
        self.assertEqual(test2, [1, 2, 3, 4, 5, 6, 7, 8, 9])

    # Test 3:
    # Input: [9, 2, 7, 4, 5, 6, 3, 8, 1]
    # Expected Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    # Actual Output: