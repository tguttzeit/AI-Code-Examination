from py_testgen_app.src.ChatGPT.BinarySearch.BookExampleCode.T4.binary_search import BinarySearch

import unittest


class TestBinarySearch(unittest.TestCase):

    def setUp(self):
        # Create an instance of the BinarySearch class for testing
        self.binary_search = BinarySearch()

    def test_binary_search_exists(self):
        # Check if the binary_search method exists
        self.assertTrue(hasattr(self.binary_search, 'binary_search'))

    def test_binary_search_empty_list(self):
        # Test when the input list is empty
        key = 5
        arr = []
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result)

    def test_binary_search_key_in_list(self):
        # Test when the key is present in the list
        key = 3
        arr = [1, 2, 3, 4, 5]
        result = self.binary_search.binary_search(key, arr)
        self.assertTrue(result)

    def test_binary_search_key_not_in_list(self):
        # Test when the key is not present in the list
        key = 6
        arr = [1, 2, 3, 4, 5]
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result)

    