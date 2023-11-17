from py_testgen_app.src.ChatGPT.Knapsack.PromptOnly.T7.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_empty_knapsack(self):
        knapsack = Knapsack()
        capacity = 10
        weights = []
        values = []
        self.assertEqual(knapsack.bottom_up(capacity, weights, values), 0)

    def test_basic_knapsack(self):
        knapsack = Knapsack()
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        self.assertEqual(knapsack.bottom_up(capacity, weights, values), 7)

    def test_large_capacity_knapsack(self):
        knapsack = Knapsack()
        capacity = 100
        weights = [10, 20, 30]
        values = [60, 100, 120]
        self.assertEqual(knapsack.bottom_up(capacity, weights, values), 220)
