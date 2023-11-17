from py_testgen_app.src.Copilot.Knapsack.AIGenerated.T2.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()

    def test(self):
        self.assertEqual(self.knapsack.bottom_up(10, [5, 4, 6, 3], [10, 40, 30, 50]), 90)
        self.assertEqual(self.knapsack.bottom_up(50, [10, 20, 30], [60, 100, 120]), 220)
        self.assertEqual(self.knapsack.bottom_up(10, [1, 2, 3, 4, 5], [10, 9, 8, 7, 6]), 10)