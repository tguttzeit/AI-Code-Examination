from py_testgen_app.src.ChatGPT.Knapsack.BookExampleCode.T5.knapsack import Knapsack

import unittest

class TestKnapsack(unittest.TestCase):

    def setUp(self):
        self.knapsack = Knapsack()

    def test_case1(self):
        capacity = 5
        weights = [2, 3, 4]
        values = [3, 4, 5]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 7)

    def test_case2(self):
        capacity = 10
        weights = [5, 4, 6, 3]
        values = [10, 40, 30, 50]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 90)

    def test_case3(self):
        capacity = 8
        weights = [1, 3, 4, 5]
        values = [1, 4, 5, 7]
        result = self.knapsack.bottom_up(capacity, weights, values)
        self.assertEqual(result, 9)
