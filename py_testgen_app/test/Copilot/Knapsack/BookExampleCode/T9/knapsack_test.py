from py_testgen_app.src.Copilot.Knapsack.BookExampleCode.T9.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_knapsack(self):
        knapsack = Knapsack()
        self.assertEqual(knapsack.bottom_up(50, [10, 20, 30], [60, 100, 120]), 220)
        self.assertEqual(knapsack.bottom_up(50, [10, 20, 30, 40], [60, 100, 120, 150]), 250)
        self.assertEqual(knapsack.bottom_up(50, [10, 20, 30, 40, 50], [60, 100, 120, 150, 170]), 280)