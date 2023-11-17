from py_testgen_app.src.Copilot.BinarySearch.PromptOnly.T5.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.TestCase):
    # Implement a test method called test_binary_search_1 that tests the binary_search() method.
    # The test case is binary_search(1, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]) == True.
    def test_binary_search_1(self):
        self.assertEqual(BinarySearch().binary_search(1, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]), True)

    # Implement a test method called test_binary_search_2 that tests the binary_search() method.
    # The test case is binary_search(2, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]) == True.
    def test_binary_search_2(self):
        self.assertEqual(BinarySearch().binary_search(2, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]), True)

    # Implement a test method called test_binary_search_3 that tests the binary_search() method.
    # The test case is binary_search(3, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]) == True.
    def test_binary_search_3(self):
        self.assertEqual(BinarySearch().binary_search(3, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]), True)

