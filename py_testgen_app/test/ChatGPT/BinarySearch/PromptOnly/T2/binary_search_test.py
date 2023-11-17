from py_testgen_app.src.ChatGPT.BinarySearch.PromptOnly.T2.binary_search import BinarySearch

import unittest

# The test class for BinarySearch
class BinarySearchTest(unittest.TestCase):
    def test_binary_search_found(self):
        # Test when the target is found in the middle of the list
        arr = [1, 2, 3, 4, 5]
        target = 3
        result = BinarySearch().binary_search(target, arr)
        self.assertTrue(result)

    def test_binary_search_not_found(self):
        # Test when the target is not in the list
        arr = [1, 2, 4, 5, 6]
        target = 3
        result = BinarySearch().binary_search(target, arr)
        self.assertFalse(result)

    def test_binary_search_empty_list(self):
        # Test when the list is empty
        arr = []
        target = 5
        result = BinarySearch().binary_search(target, arr)
        self.assertFalse(result)


