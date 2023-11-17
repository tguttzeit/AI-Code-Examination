from py_testgen_app.src.ChatGPT.Knapsack.AIGenerated.T3.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()

    def test_knapsack_case1(self):
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 10)

    def test_knapsack_case2(self):
        capacity = 8
        weights = [3, 1, 2]
        values = [5, 2, 3]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 8)

    def test_knapsack_case3(self):
        capacity = 6
        weights = [1, 2, 3]
        values = [10, 15, 40]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 65)
    