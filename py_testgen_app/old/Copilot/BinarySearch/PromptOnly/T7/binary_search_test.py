from py_testgen_app.src.Copilot.BinarySearch.PromptOnly.T7.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.TestCase):

    # Implement a test method test_binary_search_1() that tests the method binary_search() with the following parameters:
    # 1, [1, 2, 3, 4, 5]
    # The expected result is True.
    def test_binary_search_1(self):
        self.assertTrue(binary_search(1, [1, 2, 3, 4, 5]))

    # Implement a test method test_binary_search_2() that tests the method binary_search() with the following parameters:
    # 5, [1, 2, 3, 4, 5]
    # The expected result is True.
    def test_binary_search_2(self):
        self.assertTrue(binary_search(5, [1, 2, 3, 4, 5]))

    # Implement a test method test_binary_search_3() that tests the method binary_search() with the following parameters:
    # 6, [1, 2, 3, 4, 5]
    # The expected result is False.
    def test_binary_search_3(self):
        self.assertFalse(binary_search(6, [1, 2, 3, 4, 5]))
