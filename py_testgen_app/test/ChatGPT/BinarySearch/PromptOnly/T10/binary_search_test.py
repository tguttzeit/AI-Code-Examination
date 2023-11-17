from py_testgen_app.src.ChatGPT.BinarySearch.PromptOnly.T10.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.TestCase):
    def setUp(self):
        # Create an instance of the BinarySearch class for testing
        self.binary_search = BinarySearch()

    def test_binary_search_found(self):
        # Test case for finding an element that exists in the list
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        target = 5
        result = self.binary_search.binary_search(target, arr)
        self.assertTrue(result)

    def test_binary_search_not_found(self):
        # Test case for searching an element that doesn't exist in the list
        arr = [1, 2, 3, 4, 6, 7, 8, 9, 10]
        target = 5
        result = self.binary_search.binary_search(target, arr)
        self.assertFalse(result)

    def test_binary_search_empty_list(self):
        # Test case for searching in an empty list
        arr = []
        target = 5
        result = self.binary_search.binary_search(target, arr)
        self.assertFalse(result)

