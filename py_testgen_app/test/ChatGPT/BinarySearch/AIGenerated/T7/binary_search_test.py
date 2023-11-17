from py_testgen_app.src.ChatGPT.BinarySearch.AIGenerated.T7.binary_search import BinarySearch

import unittest

class TestBinarySearch(unittest.TestCase):
    def setUp(self):
        # Create an instance of the BinarySearch class to test its binary_search method
        self.binary_search_instance = BinarySearch()

    def test_element_found(self):
        # Test when the element is found in the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        target = 5
        self.assertTrue(self.binary_search_instance.binary_search(target, arr))

    def test_element_not_found(self):
        # Test when the element is not found in the array
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        target = 10
        self.assertFalse(self.binary_search_instance.binary_search(target, arr))

    def test_empty_array(self):
        # Test when searching in an empty array
        arr = []
        target = 42
        self.assertFalse(self.binary_search_instance.binary_search(target, arr))


