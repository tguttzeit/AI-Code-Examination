from py_testgen_app.src.ChatGPT.BinarySearch.BookExampleCode.T6.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):

    def setUp(self):
        # Initialize the BinarySearch object
        self.binary_search = BinarySearch()

    def test_binary_search_found(self):
        # Test when the key is found in the middle of the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        key = 5
        result = self.binary_search.binary_search(key, arr)
        self.assertTrue(result)

    def test_binary_search_not_found(self):
        # Test when the key is not in the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        key = 11
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result)

    def test_binary_search_edge_cases(self):
        # Test when the array is empty
        arr = []
        key = 5
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result)

        # Test when the array has only one element, which is the key
        arr = [42]
        key = 42
        result = self.binary_search.binary_search(key, arr)
        self.assertTrue(result)

        # Test when the array has only one element, which is not the key
        arr = [99]
        key = 42
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result)
