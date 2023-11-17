from py_testgen_app.src.ChatGPT.Knapsack.PromptOnly.T10.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):

    def test_empty_lists(self):
        knapsack = Knapsack()
        capacity = 10
        weights = []
        values = []
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 0, "Should return 0 for empty lists")

    def test_basic_case(self):
        knapsack = Knapsack()
        capacity = 5
        weights = [2, 3, 4]
        values = [3, 4, 5]
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 7, "Should return 7 for the basic case")

    def test_large_capacity(self):
        knapsack = Knapsack()
        capacity = 100
        weights = [10, 20, 30]
        values = [60, 100, 120]
        result = knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 220, "Should return 220 for a large capacity")
