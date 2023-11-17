from py_testgen_app.src.ChatGPT.Knapsack.BookExampleCode.T1.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):

    def setUp(self):
        self.knapsack = Knapsack()

    def test_knapsack_case1(self):
        capacity = 5
        weights = [2, 1, 3, 4]
        values = [3, 2, 4, 4]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 7)

    def test_knapsack_case2(self):
        capacity = 10
        weights = [5, 3, 4, 2]
        values = [10, 7, 8, 5]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 22)

    def test_knapsack_case3(self):
        capacity = 6
        weights = [3, 4, 2, 1]
        values = [5, 4, 7, 2]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 9)
