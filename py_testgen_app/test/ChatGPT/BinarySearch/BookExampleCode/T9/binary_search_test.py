from py_testgen_app.src.ChatGPT.BinarySearch.BookExampleCode.T9.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):

    def setUp(self):
        # Create an instance of the BinarySearch class for testing
        self.binary_search = BinarySearch()

    def test_existing_element(self):
        # Test when the key exists in the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        key = 5
        result = self.binary_search.binary_search(key, arr)
        self.assertTrue(result)

    def test_non_existing_element(self):
        # Test when the key does not exist in the array
        arr = [1, 2, 3, 4, 6, 7, 8, 9]
        key = 5
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result)

    def test_empty_array(self):
        # Test when searching in an empty array
        arr = []
        key = 5
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result)

    def test_single_element_array(self):
        # Test when searching in an array with a single element
        arr = [3]
        key = 3
        result = self.binary_search.binary_search(key, arr)
        self.assertTrue(result)

