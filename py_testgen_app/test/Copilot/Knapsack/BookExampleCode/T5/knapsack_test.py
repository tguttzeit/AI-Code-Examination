from py_testgen_app.src.Copilot.Knapsack.BookExampleCode.T5.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()

    def test_case1(self):
        capacity = 10
        weights = [5, 4, 6, 3]
        values = [10, 40, 30, 50]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 90)

    def test_case2(self):
        capacity = 10
        weights = [5, 4, 6, 3, 2]
        values = [10, 40, 30, 50, 100]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 150)

    def test_case3(self):
        capacity = 10
        weights = [5, 4, 6, 3, 2, 1]
        values = [10, 40, 30, 50, 100, 200]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 250)