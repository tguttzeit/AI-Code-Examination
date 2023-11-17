from py_testgen_app.src.ChatGPT.Knapsack.AIGenerated.T8.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()

    def test_knapsack_case1(self):
        capacity = 5
        weights = [2, 1, 3]
        values = [10, 6, 12]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 22)

    def test_knapsack_case2(self):
        capacity = 10
        weights = [5, 4, 6, 3]
        values = [10, 40, 30, 50]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 90)

    def test_knapsack_case3(self):
        capacity = 8
        weights = [3, 2, 4, 1]
        values = [5, 3, 5, 2]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 10)
