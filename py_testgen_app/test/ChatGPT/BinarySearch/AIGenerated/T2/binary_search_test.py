from py_testgen_app.src.ChatGPT.BinarySearch.AIGenerated.T2.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):
    def setUp(self):
        # Create an instance of the BinarySearch class for testing
        self.binary_search = BinarySearch()

    def test_element_found(self):
        # Test when the target element is found in the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        target = 5
        result = self.binary_search.binary_search(target, arr)
        self.assertTrue(result)

    def test_element_not_found(self):
        # Test when the target element is not found in the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        target = 11
        result = self.binary_search.binary_search(target, arr)
        self.assertFalse(result)

    def test_empty_array(self):
        # Test when searching in an empty array
        arr = []
        target = 5
        result = self.binary_search.binary_search(target, arr)
        self.assertFalse(result)

