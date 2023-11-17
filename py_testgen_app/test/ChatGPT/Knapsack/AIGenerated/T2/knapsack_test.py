from py_testgen_app.src.ChatGPT.Knapsack.AIGenerated.T2.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()

    def test_knapsack_case1(self):
        capacity = 10
        weights = [2, 3, 4, 5]
        values = [3, 4, 5, 6]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 10, "Test case 1 failed")

    def test_knapsack_case2(self):
        capacity = 5
        weights = [2, 3, 4]
        values = [3, 4, 5]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 7, "Test case 2 failed")

    def test_knapsack_case3(self):
        capacity = 8
        weights = [1, 3, 4, 5]
        values = [1, 4, 5, 7]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 9, "Test case 3 failed")
