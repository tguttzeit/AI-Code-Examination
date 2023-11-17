from py_testgen_app.src.ChatGPT.Knapsack.PromptOnly.T6.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_empty_knapsack(self):
        self.assertEqual(Knapsack().bottom_up(0, [], []), 0)

    def test_single_item_knapsack(self):
        capacity = 10
        weights = [5]
        values = [8]
        self.assertEqual(Knapsack().bottom_up(capacity, weights, values), 8)

    def test_multiple_items_knapsack(self):
        capacity = 15
        weights = [5, 10, 6, 3]
        values = [8, 15, 10, 4]
        self.assertEqual(Knapsack().bottom_up(capacity, weights, values), 19)
