from py_testgen_app.src.Copilot.QuickSort.BookExampleCode.T2.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_sort(self):
        qs = QuickSort()

        # Test case 1: empty array
        unsorted_array = []
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [])

        # Test case 2: array with one element
        unsorted_array = [1]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1])

        # Test case 3: array with two elements
        unsorted_array = [2, 1]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2])

        # Test case 4: array with three elements
        unsorted_array = [2, 1, 3]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3])

        # Test case 5: array with multiple elements
        unsorted_array = [2, 1, 5, 4, 3]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5])

        # Test case 6: array with multiple elements
        unsorted_array = [2, 1, 5, 4, 3, 6]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6])

        # Test case 7: array with multiple elements
        unsorted_array = [2, 1, 5, 4, 3, 6, 7]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7])

        # Test case 8: array with multiple elements
        unsorted_array = [2, 1, 5, 4, 3, 6, 7, 8]
        qs.sort(unsorted_array)
        self.assertEqual(unsorted_array, [1, 2, 3, 4, 5, 6, 7, 8])

        # Test case 9: array with multiple elements
        unsorted_array = [2, 1, 5, 4, 3, 6, 7, 8, 9]
        qs.sort