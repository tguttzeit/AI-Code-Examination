from py_testgen_app.src.Copilot.BinarySearch.PromptOnly.T6.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.TestCase):
    # Implement at least 3 different test cases.
    # Test case #1: Test whether the output of the method binary_search() is correct for the following input parameters:
    # 2, [1, 2, 3, 4, 5]
    def test_binary_search_1(self):
        # Arrange
        binary_search = BinarySearch()
        # Act
        result = binary_search.binary_search(2, [1, 2, 3, 4, 5])
        # Assert
        self.assertEqual(result, True)

    # Test case #2: Test whether the output of the method binary_search() is correct for the following input parameters:
    # 6, [1, 2, 3, 4, 5]
    def test_binary_search_2(self):
        # Arrange
        binary_search = BinarySearch()
        # Act
        result = binary_search.binary_search(6, [1, 2, 3, 4, 5])
        # Assert
        self.assertEqual(result, False)

    # Test case #3: Test whether the output of the method binary_search() is correct for the following input parameters:
    # 4, [1, 2, 3, 4, 5]
    def test_binary_search_3(self):
        # Arrange
        binary_search = BinarySearch()
        # Act
        result = binary_search.binary_search(4, [1, 2, 3, 4, 5])
        # Assert
        self.assertEqual(result, True)
