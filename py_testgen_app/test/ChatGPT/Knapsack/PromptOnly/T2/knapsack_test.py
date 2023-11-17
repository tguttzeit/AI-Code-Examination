from py_testgen_app.src.ChatGPT.Knapsack.PromptOnly.T2.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):

    def test_bottom_up_empty_lists(self):
        # Test when both weights and values lists are empty
        capacity = 10
        weights = []
        values = []
        knapsack = Knapsack()
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 0)

    def test_bottom_up_single_item(self):
        # Test when there is only one item in the knapsack
        capacity = 5
        weights = [3]
        values = [7]
        knapsack = Knapsack()
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 7)

    def test_bottom_up_multiple_items(self):
        # Test with multiple items in the knapsack
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        knapsack = Knapsack()
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 7 + 6)  # Maximum value is achieved by selecting items with weights 3 and 4

