from py_testgen_app.src.ChatGPT.QuickSort.AIGenerated.T2.quick_sort import QuickSort

import unittest

class TestQuickSort(unittest.TestCase):

    def setUp(self):
        self.quicksort = QuickSort()

    def test_sort_empty_list(self):
        unsorted_array = []
        self.quicksort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [])

    def test_sort_sorted_list(self):
        unsorted_array = [1, 2, 3, 4, 5]
        self.quicksort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])

    def test_sort_reverse_sorted_list(self):
        unsorted_array = [5, 4, 3, 2, 1]
        self.quicksort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])
