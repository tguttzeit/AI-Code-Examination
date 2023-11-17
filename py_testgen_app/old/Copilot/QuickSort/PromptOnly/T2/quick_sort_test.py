from py_testgen_app.src.Copilot.QuickSort.PromptOnly.T2.quick_sort import QuickSort

import unittest

class QuickSortTest(unittest.TestCase):
    def test_quick_sort(self):
        # Test case 1
        # Arrange
        expected = [1, 2, 3, 4, 5, 6, 7, 8, 9]

        # Act
        actual = QuickSort.quick_sort(self, [9, 8, 7, 6, 5, 4, 3, 2, 1])

        # Assert
        self.assertEqual(expected, actual)

    def test_quick_sort2(self):
        # Test case 2
        # Arrange
        expected = [1, 2, 3, 4, 5, 6, 7, 8, 9]

        # Act
        actual = QuickSort.quick_sort(self, [1, 2, 3, 4, 5, 6, 7, 8, 9])

        # Assert
        self.assertEqual(expected, actual)

    def test_quick_sort3(self):
        # Test case 3
        # Arrange
        expected = [1, 2, 3, 4, 5, 6, 7, 8, 9]

        # Act
        actual = QuickSort.quick_sort(self, [5, 3, 1, 2, 4, 6, 7, 8, 9])

        # Assert
        self.assertEqual(expected, actual)