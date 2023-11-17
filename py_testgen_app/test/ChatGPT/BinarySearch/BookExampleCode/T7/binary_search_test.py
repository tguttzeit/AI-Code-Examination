from py_testgen_app.src.ChatGPT.BinarySearch.BookExampleCode.T7.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):

    def setUp(self):
        # Create an instance of the BinarySearch class to use in test methods
        self.binary_search = BinarySearch()

    def test_existing_element(self):
        # Test when the key exists in the array
        arr = [1, 3, 5, 7, 9, 11]
        key = 5
        self.assertTrue(self.binary_search.binary_search(key, arr))

    def test_non_existing_element(self):
        # Test when the key does not exist in the array
        arr = [1, 3, 5, 7, 9, 11]
        key = 6
        self.assertFalse(self.binary_search.binary_search(key, arr))

    def test_empty_array(self):
        # Test when the array is empty
        arr = []
        key = 8
        self.assertFalse(self.binary_search.binary_search(key, arr))

