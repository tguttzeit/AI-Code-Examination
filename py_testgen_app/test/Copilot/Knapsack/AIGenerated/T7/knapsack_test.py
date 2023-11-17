from py_testgen_app.src.Copilot.Knapsack.AIGenerated.T7.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_bottom_up(self):
        knapsack = Knapsack()
        self.assertEqual(knapsack.bottom_up(5, [1, 2, 3, 4], [1, 2, 3, 4]), 5)
        self.assertEqual(knapsack.bottom_up(10, [5, 4, 3, 2, 1], [1, 2, 3, 4, 5]), 15)
        self.assertEqual(knapsack.bottom_up(7, [1, 2, 3, 4, 5], [5, 4, 3, 2, 1]), 9)