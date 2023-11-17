from py_testgen_app.src.ChatGPT.BinarySearch.BookExampleCode.T5.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):
    def setUp(self):
        # Create an instance of the BinarySearch class to use in the tests
        self.binary_search = BinarySearch()

    def test_element_found(self):
        # Test when the key is found in the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        key = 5
        self.assertTrue(self.binary_search.binary_search(key, arr))

    def test_element_not_found(self):
        # Test when the key is not found in the array
        arr = [1, 2, 3, 4, 6, 7, 8, 9, 10]
        key = 5
        self.assertFalse(self.binary_search.binary_search(key, arr))

    def test_empty_array(self):
        # Test when the array is empty
        arr = []
        key = 5
        self.assertFalse(self.binary_search.binary_search(key, arr))

    def test_single_element_array(self):
        # Test when the array has a single element
        arr = [5]
        key = 5
        self.assertTrue(self.binary_search.binary_search(key, arr))

