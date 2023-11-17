from py_testgen_app.src.ChatGPT.Knapsack.PromptOnly.T8.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_empty_lists(self):
        knapsack = Knapsack()
        capacity = 10
        weights = []
        values = []
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 0)

    def test_single_item_fits(self):
        knapsack = Knapsack()
        capacity = 10
        weights = [5]
        values = [15]
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 15)

    def test_multiple_items(self):
        knapsack = Knapsack()
        capacity = 10
        weights = [5, 3, 2, 4]
        values = [15, 10, 9, 5]
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 25)
