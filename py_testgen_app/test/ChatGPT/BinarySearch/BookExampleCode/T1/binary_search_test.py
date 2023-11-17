from py_testgen_app.src.ChatGPT.BinarySearch.BookExampleCode.T1.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):

    def setUp(self):
        # Create an instance of the BinarySearch class for testing
        self.binary_search = BinarySearch()

    def test_binary_search_found(self):
        # Test the binary_search method when the key is found in the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        key = 7
        result = self.binary_search.binary_search(key, arr)
        self.assertTrue(result, f"Key {key} not found when it should be")

    def test_binary_search_not_found(self):
        # Test the binary_search method when the key is not found in the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        key = 11
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result, f"Key {key} found when it should not be")

    def test_binary_search_empty_array(self):
        # Test the binary_search method with an empty array
        arr = []
        key = 5
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result, "Binary search should return False for empty array")

