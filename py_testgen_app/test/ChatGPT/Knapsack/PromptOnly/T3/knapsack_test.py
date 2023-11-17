from py_testgen_app.src.ChatGPT.Knapsack.PromptOnly.T3.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):

    def test_empty_knapsack(self):
        knapsack = Knapsack()
        capacity = 10
        weights = []
        values = []
        self.assertEqual(knapsack.bottom_up(capacity, weights, values), 0)

    def test_single_item_fits(self):
        knapsack = Knapsack()
        capacity = 10
        weights = [5]
        values = [10]
        self.assertEqual(knapsack.bottom_up(capacity, weights, values), 10)

    def test_multiple_items(self):
        knapsack = Knapsack()
        capacity = 10
        weights = [5, 3, 2, 7]
        values = [10, 7, 4, 14]
        self.assertEqual(knapsack.bottom_up(capacity, weights, values), 18)
