from py_testgen_app.src.Copilot.Knapsack.PromptOnly.T8.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_knapsack_1(self):
        capacity = 10
        weights = [1, 3, 4, 5]
        values = [1, 4, 5, 7]
        expected = 9

        self.assertEqual(Knapsack().bottom_up(capacity, weights, values), expected)

    def test_knapsack_2(self):
        capacity = 10
        weights = [1, 2, 3, 4]
        values = [10, 9, 8, 7]
        expected = 10

        self.assertEqual(Knapsack().bottom_up(capacity, weights, values), expected)

    def test_knapsack_3(self):
        capacity = 10
        weights = [1, 2, 3, 4]
        values = [1, 2, 3, 4]
        expected = 10

        self.assertEqual(Knapsack().bottom_up(capacity, weights, values), expected)