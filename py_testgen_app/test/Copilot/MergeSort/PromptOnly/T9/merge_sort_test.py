from py_testgen_app.src.Copilot.MergeSort.PromptOnly.T9.merge_sort import MergeSort

import unittest

class MergeSortTest(unittest.TestCase):
    def setUp(self):
        self.mergesort = MergeSort()

    # Define a test case that asserts that the method merge_sort() returns the expected result for a given input.
    def test_merge_sort(self):
        self.assertEqual(self.mergesort.merge_sort([4, 2, 1, 3]), [1, 2, 3, 4])
        self.assertEqual(self.mergesort.merge_sort([1, 2, 3, 4]), [1, 2, 3, 4])
        self.assertEqual(self.mergesort.merge_sort([4, 3, 2, 1]), [1, 2, 3, 4])
