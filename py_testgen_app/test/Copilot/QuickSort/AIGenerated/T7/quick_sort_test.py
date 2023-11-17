from py_testgen_app.src.Copilot.QuickSort.AIGenerated.T7.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_quick_sort(self):
        quick_sort = QuickSort()
        unsorted_array = [2, 1, 3]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3])

    def test_quick_sort_with_empty_array(self):
        quick_sort = QuickSort()
        unsorted_array = []
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [])

    def test_quick_sort_with_sorted_array(self):
        quick_sort = QuickSort()
        unsorted_array = [1, 2, 3]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3])

    def test_quick_sort_with_reversed_array(self):
        quick_sort = QuickSort()
        unsorted_array = [3, 2, 1]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3])

    def test_quick_sort_with_one_element_array(self):
        quick_sort = QuickSort()
        unsorted_array = [1]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1])

    def test_quick_sort_with_negative_numbers(self):
        quick_sort = QuickSort()
        unsorted_array = [-1, -2, -3, -4]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [-4, -3, -2, -1])

    def test_quick_sort_with_duplicated_numbers(self):
        quick_sort = QuickSort()
        unsorted_array = [1, 1, 1, 1]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 1, 1, 1])

    def test_quick_sort_with_duplicated_numbers1(self):
        quick_sort = QuickSort()
        unsorted_array = [1, 1, 1, 1]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 1, 1, 1])

    def test_quick_sort_with_duplicated_numbers2(self):
        quick_sort = QuickSort()
        unsorted_array = [1, 1, 1, 1]
        quick_sort.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 1, 1, 1])

    def test_quick_sort_with(self):
        pass