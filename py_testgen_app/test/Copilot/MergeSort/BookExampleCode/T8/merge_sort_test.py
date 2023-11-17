from py_testgen_app.src.Copilot.MergeSort.BookExampleCode.T8.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def setUp(self):
        self.mergesort = MergeSort()
        
    def test_merge_sort(self):
        self.assertEqual(self.mergesort.merge_sort([3, 5, 2, 4, 1]), [1, 2, 3, 4, 5])
        self.assertEqual(self.mergesort.merge_sort([1, 2, 3, 4, 5]), [1, 2, 3, 4, 5])
        self.assertEqual(self.mergesort.merge_sort([5, 4, 3, 2, 1]), [1, 2, 3, 4, 5])
        
    def test_merge(self):
        self.assertEqual(self.mergesort.merge([1, 3, 5], [2, 4]), [1, 2, 3, 4, 5])
        self.assertEqual(self.mergesort.merge([2, 4], [1, 3, 5]), [1, 2, 3, 4, 5])
        self.assertEqual(self.mergesort.merge([1, 2, 3], [4, 5]), [1, 2, 3, 4, 5])
