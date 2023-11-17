from py_testgen_app.src.Copilot.QuickSort.PromptOnly.T6.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_quick_sort(self):
        qs = QuickSort()
        self.assertEqual(qs.sort([3, 2, 1]), [1, 2, 3])
        self.assertEqual(qs.sort([3, 2, 1, 4, 5]), [1, 2, 3, 4, 5])
        self.assertEqual(qs.sort([1, 1, 1, 1, 1]), [1, 1, 1, 1, 1])