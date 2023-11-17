from py_testgen_app.src.ChatGPT.BinarySearch.BookExampleCode.T10.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):

    def setUp(self):
        self.binary_search = BinarySearch()

    def test_existing_element(self):
        # Test when the key exists in the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        key = 5
        result = self.binary_search.binary_search(key, arr)
        self.assertTrue(result)

    def test_non_existing_element(self):
        # Test when the key doesn't exist in the array
        arr = [1, 2, 3, 4, 6, 7, 8, 9]
        key = 5
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result)

    def test_empty_array(self):
        # Test with an empty array
        arr = []
        key = 42
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result)

