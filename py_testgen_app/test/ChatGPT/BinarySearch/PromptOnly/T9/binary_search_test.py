from py_testgen_app.src.ChatGPT.BinarySearch.PromptOnly.T9.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.TestCase):

    def test_binary_search_existing_element(self):
        # Test when the element exists in the list
        binary_search = BinarySearch()
        input_list = [1, 2, 3, 4, 5, 6]
        target = 3
        result = binary_search.binary_search(target, input_list)
        self.assertTrue(result)

    def test_binary_search_non_existing_element(self):
        # Test when the element does not exist in the list
        binary_search = BinarySearch()
        input_list = [1, 2, 3, 4, 5, 6]
        target = 7
        result = binary_search.binary_search(target, input_list)
        self.assertFalse(result)

    def test_binary_search_empty_list(self):
        # Test when the list is empty
        binary_search = BinarySearch()
        input_list = []
        target = 5
        result = binary_search.binary_search(target, input_list)
        self.assertFalse(result)

