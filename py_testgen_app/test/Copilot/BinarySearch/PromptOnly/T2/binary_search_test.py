from py_testgen_app.src.Copilot.BinarySearch.PromptOnly.T2.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.TestCase):
    # Implement a test method test_binary_search_1() to test the method binary_search().
    def test_binary_search_1(self):
        # Test case 1: The integer 5 is contained in the integer list [1, 2, 3, 4, 5].
        # The method binary_search() should return True.
        self.assertTrue(BinarySearch().binary_search(5, [1, 2, 3, 4, 5]))

    # Implement a test method test_binary_search_2() to test the method binary_search().
    def test_binary_search_2(self):
        # Test case 2: The integer 3 is contained in the integer list [1, 2, 3, 4, 5].
        # The method binary_search() should return True.
        self.assertTrue(BinarySearch().binary_search(3, [1, 2, 3, 4, 5]))

    # Implement a test method test_binary_search_3() to test the method binary_search().
    def test_binary_search_3(self):
        # Test case 3: The integer 1 is contained in the integer list [1, 2, 3, 4, 5].
        # The method binary_search() should return True.
        self.assertTrue(BinarySearch().binary_search(1, [1, 2, 3, 4, 5]))

