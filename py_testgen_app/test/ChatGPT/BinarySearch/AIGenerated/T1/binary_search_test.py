from py_testgen_app.src.ChatGPT.BinarySearch.AIGenerated.T1.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):
    def setUp(self):
        # Create an instance of the BinarySearch class
        self.binary_search = BinarySearch()

    def test_existing_element(self):
        # Test when the target element exists in the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        target = 5
        self.assertTrue(self.binary_search.binary_search(target, arr))

    def test_non_existing_element(self):
        # Test when the target element does not exist in the array
        arr = [1, 2, 3, 4, 6, 7, 8, 9, 10]
        target = 5
        self.assertFalse(self.binary_search.binary_search(target, arr))

    def test_empty_array(self):
        # Test when the array is empty
        arr = []
        target = 42
        self.assertFalse(self.binary_search.binary_search(target, arr))

