from py_testgen_app.src.ChatGPT.BinarySearch.AIGenerated.T6.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):
    def setUp(self):
        # Create an instance of the BinarySearch class
        self.binary_search = BinarySearch()

    def test_element_found(self):
        # Test when the target element is found in the array
        arr = [1, 2, 3, 4, 5, 6, 7]
        target = 4
        result = self.binary_search.binary_search(target, arr)
        self.assertTrue(result)

    def test_element_not_found(self):
        # Test when the target element is not found in the array
        arr = [1, 2, 3, 4, 5, 6, 7]
        target = 8
        result = self.binary_search.binary_search(target, arr)
        self.assertFalse(result)

    def test_empty_array(self):
        # Test when the array is empty
        arr = []
        target = 42
        result = self.binary_search.binary_search(target, arr)
        self.assertFalse(result)

    def test_single_element_array(self):
        # Test when the array has a single element, and it matches the target
        arr = [42]
        target = 42
        result = self.binary_search.binary_search(target, arr)
        self.assertTrue(result)

