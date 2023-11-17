from py_testgen_app.src.Copilot.QuickSort.BookExampleCode.T9.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_quick_sort(self):
        # Arrange
        quick_sort = QuickSort()
        unsorted_array = [1, 5, 2, 3, 7, 4]
        expected_sorted_array = [1, 2, 3, 4, 5, 7]

        # Act
        quick_sort.sort(unsorted_array)

        # Assert
        self.assertEqual(unsorted_array, expected_sorted_array)

    def test_quick_sort_with_empty_array(self):
        # Arrange
        quick_sort = QuickSort()
        unsorted_array = []
        expected_sorted_array = []

        # Act
        quick_sort.sort(unsorted_array)

        # Assert
        self.assertEqual(unsorted_array, expected_sorted_array)

    def test_quick_sort_with_one_element_array(self):
        # Arrange
        quick_sort = QuickSort()
        unsorted_array = [1]
        expected_sorted_array = [1]

        # Act
        quick_sort.sort(unsorted_array)

        # Assert
        self.assertEqual(unsorted_array, expected_sorted_array)

    def test_quick_sort_with_reversed_array(self):
        # Arrange
        quick_sort = QuickSort()
        unsorted_array = [7, 6, 5, 4, 3, 2, 1]
        expected_sorted_array = [1, 2, 3, 4, 5, 6, 7]

        # Act
        quick_sort.sort(unsorted_array)

        # Assert
        self.assertEqual(unsorted_array, expected_sorted_array)