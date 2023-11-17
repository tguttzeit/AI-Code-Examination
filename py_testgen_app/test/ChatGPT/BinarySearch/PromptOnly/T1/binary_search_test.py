from py_testgen_app.src.ChatGPT.BinarySearch.PromptOnly.T1.binary_search import BinarySearch

import unittest

# Define the test class
class BinarySearchTest(unittest.TestCase):

    def test_binary_search_exists(self):
        # Test if the binary_search method exists in BinarySearch class
        self.assertTrue(hasattr(BinarySearch, 'binary_search'))

    def test_binary_search_found(self):
        # Test when the target element is found in the list
        arr = [1, 3, 5, 7, 9]
        target = 5
        result = BinarySearch().binary_search(target, arr)
        self.assertTrue(result)

    def test_binary_search_not_found(self):
        # Test when the target element is not found in the list
        arr = [1, 3, 5, 7, 9]
        target = 4
        result = BinarySearch().binary_search(target, arr)
        self.assertFalse(result)

    def test_binary_search_empty_list(self):
        # Test when searching in an empty list
        arr = []
        target = 42
        result = BinarySearch().binary_search(target, arr)
        self.assertFalse(result)


