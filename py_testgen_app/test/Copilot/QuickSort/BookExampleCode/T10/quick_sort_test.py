from py_testgen_app.src.Copilot.QuickSort.BookExampleCode.T10.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_quick_sort(self):
        qs = QuickSort()
        unsorted_array = [3, 2, 1]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3])

    def test_quick_sort_with_duplicates(self):
        qs = QuickSort()
        unsorted_array = [3, 2, 1, 1]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 1, 2, 3])

    def test_quick_sort_with_empty_array(self):
        qs = QuickSort()
        unsorted_array = []
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [])

    def test_quick_sort_with_sorted_array(self):
        qs = QuickSort()
        unsorted_array = [1, 2, 3]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3])

    def test_quick_sort_with_negative_numbers(self):
        qs = QuickSort()
        unsorted_array = [-1, -2, -3]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [-3, -2, -1])

    def test_quick_sort_with_mixed_numbers(self):
        qs = QuickSort()
        unsorted_array = [-1, 2, -3]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [-3, -1, 2])

    def test_quick_sort_with_array_of_size_one(self):
        qs = QuickSort()
        unsorted_array = [1]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1])

    def test_quick_sort_with_array_of_size_two(self):
        qs = QuickSort()
        unsorted_array = [2, 1]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2])

    def test_quick_sort_with_array_of_size_three(self):
        qs = QuickSort()
        unsorted_array = [2, 1, 3]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3])

    def test_quick_sort_with_array_of_size_four(self):
        qs = QuickSort()
        unsorted_array = [2, 1, 3, 4]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, 1)