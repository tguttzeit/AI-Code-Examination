from py_testgen_app.src.ChatGPT.Knapsack.AIGenerated.T1.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()

    def test_case_1(self):
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 10)  # Optimal solution is to take items with weights [3, 4] for a total value of 10.

    def test_case_2(self):
        capacity = 7
        weights = [2, 2, 3, 5]
        values = [2, 3, 4, 7]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 9)  # Optimal solution is to take items with weights [2, 5] for a total value of 9.

    def test_case_3(self):
        capacity = 5
        weights = [1, 2, 3, 4]
        values = [5, 3, 2, 1]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 5)  # Optimal solution is to take the item with weight 1 for a total value of 5.
