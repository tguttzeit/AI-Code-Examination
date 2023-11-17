from py_testgen_app.src.Copilot.QuickSort.PromptOnly.T1.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort(self):
        quick_sort = QuickSort()
        self.assertEqual(quick_sort.sort([]), None)
        self.assertEqual(quick_sort.sort([1]), None)
        self.assertEqual(quick_sort.sort([1,2,3,4,5]), None)
        self.assertEqual(quick_sort.sort([5,4,3,2,1]), None)
        self.assertEqual(quick_sort.sort([1,2,3,4,5,6,7,8,9,10]), None)
        self.assertEqual(quick_sort.sort([10,9,8,7,6,5,4,3,2,1]), None)
        self.assertEqual(quick_sort.sort([1,1,1,1,1,1,1,1,1,1]), None)
        self.assertEqual(quick_sort.sort([2,2,2,2,2,2,2,2,2,2]), None)
        self.assertEqual(quick_sort.sort([3,3,3,3,3,3,3,3,3,3]), None)
        self.assertEqual(quick_sort.sort([4,4,4,4,4,4,4,4,4,4]), None)
        self.assertEqual(quick_sort.sort([5,5,5,5,5,5,5,5,5,5]), None)
        self.assertEqual(quick_sort.sort([6,6,6,6,6,6,6,6,6,6]), None)
        self.assertEqual(quick_sort.sort([7,7,7,7,7,7,7,7,7,7]), None)
        self.assertEqual(quick_sort.sort([8,8,8,8,8,8,8,8,8,8]), None)
        self.assertEqual(quick_sort.sort([9,9,9,9,9,9,9,9,9,9]), None)
        self.assertEqual(quick_sort.sort([10,10,10,10,10,10,10,10,10,10]), None)
        self.assertEqual(quick_sort.sort([1,2,3,4,5,6,7,8,9,10]), None)
        self.assertEqual(quick_sort.sort([10,9,8,7,6,5,4,3,2,1]), None)
        self.assertEqual