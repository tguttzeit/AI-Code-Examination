from py_testgen_app.src.Copilot.Knapsack.BookExampleCode.T7.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_knapsack(self):
        knapsack = Knapsack()
        self.assertEqual(knapsack.bottom_up(50, [10, 20, 30], [60, 100, 120]), 220)
        self.assertEqual(knapsack.bottom_up(10, [1, 2, 3], [5, 4, 3]), 5)
        self.assertEqual(knapsack.bottom_up(10, [1, 2, 3], [5, 4, 3]), 5)