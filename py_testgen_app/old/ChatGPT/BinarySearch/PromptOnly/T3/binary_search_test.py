from py_testgen_app.src.ChatGPT.BinarySearch.PromptOnly.T3.binary_search import BinarySearch

import unittest

# The test class
class BinarySearchTest(unittest.TestCase):
    def test_existing_element(self):
        # Test when the target element exists in the list
        arr = [1, 2, 3, 4, 5]
        target = 3
        result = BinarySearch.binary_search(target, arr)
        self.assertTrue(result)

    def test_non_existing_element(self):
        # Test when the target element does not exist in the list
        arr = [1, 2, 3, 4, 5]
        target = 6
        result = BinarySearch.binary_search(target, arr)
        self.assertFalse(result)

    def test_empty_list(self):
        # Test when the list is empty
        arr = []
        target = 5
        result = BinarySearch.binary_search(target, arr)
        self.assertFalse(result)


