from py_testgen_app.src.ChatGPT.BinarySearch.AIGenerated.T10.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):
    def setUp(self):
        # Create an instance of the BinarySearch class for testing
        self.binary_search = BinarySearch()

    def test_element_found(self):
        # Test when the target element is found in the middle of the array
        arr = [1, 3, 5, 7, 9]
        target = 5
        self.assertTrue(self.binary_search.binary_search(target, arr))

    def test_element_not_found(self):
        # Test when the target element is not in the array
        arr = [1, 3, 5, 7, 9]
        target = 6
        self.assertFalse(self.binary_search.binary_search(target, arr))

    def test_empty_array(self):
        # Test when the array is empty
        arr = []
        target = 10
        self.assertFalse(self.binary_search.binary_search(target, arr))

    def test_single_element_array(self):
        # Test when the array has a single element
        arr = [5]
        target = 5
        self.assertTrue(self.binary_search.binary_search(target, arr))

