from py_testgen_app.src.ChatGPT.BinarySearch.BookExampleCode.T3.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):

    def setUp(self):
        # Initialize the BinarySearch class for testing
        self.binary_search = BinarySearch()

    def test_existing_element(self):
        # Test when the key is present in the array
        arr = [1, 2, 3, 4, 5]
        key = 3
        result = self.binary_search.binary_search(key, arr)
        self.assertTrue(result, f"Expected {key} to be found in {arr}")

    def test_non_existing_element(self):
        # Test when the key is not present in the array
        arr = [1, 2, 3, 4, 5]
        key = 6
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result, f"Expected {key} not to be found in {arr}")

    def test_empty_array(self):
        # Test when the array is empty
        arr = []
        key = 42
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result, f"Expected {key} not to be found in an empty array")

