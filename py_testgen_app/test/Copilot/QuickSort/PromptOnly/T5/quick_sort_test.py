from py_testgen_app.src.Copilot.QuickSort.PromptOnly.T5.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    # Test case 1
    def test_sort1(self):
        # Create an object of type QuickSort
        qs = QuickSort()
        # Create an integer list with 5 elements
        arr = [2, 5, 1, 3, 4]
        # Create an integer list with 5 elements that is sorted
        expected = [1, 2, 3, 4, 5]
        # Call the sort() method of the object of type QuickSort
        qs.sort(arr)
        # Check if the sorted list is the same as the expected list
        self.assertEqual(arr, expected)

    # Test case 2
    def test_sort2(self):
        # Create an object of type QuickSort
        qs = QuickSort()
        # Create an integer list with 5 elements
        arr = [1, 3, 2, 5, 4]
        # Create an integer list with 5 elements that is sorted
        expected = [1, 2, 3, 4, 5]
        # Call the sort() method of the object of type QuickSort
        qs.sort(arr)
        # Check if the sorted list is the same as the expected list
        self.assertEqual(arr, expected)

    # Test case 3
    def test_sort3(self):
        # Create an object of type QuickSort
        qs = QuickSort()
        # Create an integer list with 5 elements
        arr = [5, 4, 3, 2, 1]
        # Create an integer list with 5 elements that is sorted
        expected = [1, 2, 3, 4, 5]
        # Call the sort() method of the object of type QuickSort
        qs.sort(arr)
        # Check if the sorted list is the same as the expected list
        self.assertEqual(arr, expected)