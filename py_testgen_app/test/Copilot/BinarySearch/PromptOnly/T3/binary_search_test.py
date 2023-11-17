from py_testgen_app.src.Copilot.BinarySearch.PromptOnly.T3.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.TestCase):
    # Implement a test method called test_binary_search_1() without parameters.
    # The test method calls the method binary_search() with the following parameters:
    # 5 and [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].
    # The test method checks if the result of binary_search() is True.
    def test_binary_search_1(self):
        self.assertEqual(BinarySearch().binary_search(5, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]), True)

    # Implement a test method called test_binary_search_2() without parameters.
    # The test method calls the method binary_search() with the following parameters:
    # 11 and [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].
    # The test method checks if the result of binary_search() is False.
    def test_binary_search_2(self):
        self.assertEqual(BinarySearch().binary_search(11, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]), False)

    # Implement a test method called test_binary_search_3() without parameters.
    # The test method calls the method binary_search() with the following parameters:
    # 10 and [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].
    # The test method checks if the result of binary_search() is True.
    def test_binary_search_3(self):
        self.assertEqual(BinarySearch().binary_search(10, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]), True)
