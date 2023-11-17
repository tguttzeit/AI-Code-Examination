from py_testgen_app.src.ChatGPT.BinarySearch.PromptOnly.T8.binary_search import BinarySearch

import unittest

class BinarySearchTest(unittest.TestCase):

    def test_binary_search_found(self):
        nums = [1, 3, 5, 7, 9]
        target = 5
        result = BinarySearch().binary_search(target, nums)
        self.assertTrue(result, f"Expected {target} to be found in {nums}")

    def test_binary_search_not_found(self):
        nums = [1, 3, 5, 7, 9]
        target = 4
        result = BinarySearch().binary_search(target, nums)
        self.assertFalse(result, f"Expected {target} not to be found in {nums}")

    def test_binary_search_empty_list(self):
        nums = []
        target = 10
        result = BinarySearch().binary_search(target, nums)
        self.assertFalse(result, f"Expected {target} not to be found in an empty list")
