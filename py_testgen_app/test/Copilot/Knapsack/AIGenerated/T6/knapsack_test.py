from py_testgen_app.src.Copilot.Knapsack.AIGenerated.T6.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_knapsack(self):
        knapsack = Knapsack()
        self.assertEqual(knapsack.bottom_up(50, [10, 20, 30], [60, 100, 120]), 220)
        self.assertEqual(knapsack.bottom_up(8, [2, 3, 5], [3, 4, 6]), 7)
        self.assertEqual(knapsack.bottom_up(10, [1, 3, 4, 5], [1, 4, 5, 7]), 9)