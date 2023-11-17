from py_testgen_app.src.ChatGPT.Knapsack.AIGenerated.T5.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()

    def test_case_1(self):
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 10)

    def test_case_2(self):
        capacity = 8
        weights = [2, 2, 3, 5]
        values = [3, 4, 5, 6]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 9)

    def test_case_3(self):
        capacity = 5
        weights = [1, 2, 3, 4, 5]
        values = [1, 2, 3, 4, 5]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 5)
