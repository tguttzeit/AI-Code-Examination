from py_testgen_app.src.Copilot.QuickSort.PromptOnly.T9.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort(self):
        qs = QuickSort()
        self.assertEqual(qs.sort([3, 2, 1]), [1, 2, 3])
        self.assertEqual(qs.sort([1, 2, 3]), [1, 2, 3])
        self.assertEqual(qs.sort([1, 3, 2]), [1, 2, 3])
        self.assertEqual(qs.sort([2, 1, 3]), [1, 2, 3])
        self.assertEqual(qs.sort([2, 3, 1]), [1, 2, 3])
        self.assertEqual(qs.sort([3, 1, 2]), [1, 2, 3])
        self.assertEqual(qs.sort([3, 2, 1]), [1, 2, 3])
        self.assertEqual(qs.sort([3, 2, 2]), [2, 2, 3])
        self.assertEqual(qs.sort([3, 2, 3]), [2, 3, 3])
        self.assertEqual(qs.sort([3, 3, 2]), [2, 3, 3])
        self.assertEqual(qs.sort([3, 3, 3]), [3, 3, 3])
        self.assertEqual(qs.sort([3, 2, 1, 2, 3, 1, 2, 3]), [1, 1, 2, 2, 2, 3, 3, 3])
        self.assertEqual(qs.sort([3, 2, 1, 2, 3, 1, 2, 3]), [1, 1, 2, 2, 2, 3, 3, 3])
        self.assertEqual(qs.sort([3, 2, 1, 2, 3, 1, 2, 3]), [1, 1, 2, 2, 2, 3, 3, 3])
        self.assertEqual(qs.sort([3, 2, 1, 2, 3, 1, 2, 3]), [1, 1, 2, 2, 2, 3, 3, 3])
        self.assertEqual(qs.sort([]), 5)