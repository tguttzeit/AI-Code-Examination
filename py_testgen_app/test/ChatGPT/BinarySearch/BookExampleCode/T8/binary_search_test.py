from py_testgen_app.src.ChatGPT.BinarySearch.BookExampleCode.T8.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):
    def setUp(self):
        self.binary_search = BinarySearch()

    def test_search_existing_element(self):
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        key = 5
        result = self.binary_search.binary_search(key, arr)
        self.assertTrue(result, f"Expected {key} to be found in the array")

    def test_search_non_existing_element(self):
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        key = 10
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result, f"Expected {key} not to be found in the array")

    def test_search_empty_array(self):
        arr = []
        key = 5
        result = self.binary_search.binary_search(key, arr)
        self.assertFalse(result, f"Expected {key} not to be found in an empty array")
