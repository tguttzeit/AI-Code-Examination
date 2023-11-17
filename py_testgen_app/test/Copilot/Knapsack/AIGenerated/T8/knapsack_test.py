from py_testgen_app.src.Copilot.Knapsack.AIGenerated.T8.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test1(self):
        knapsack = Knapsack()
        self.assertEqual(knapsack.bottom_up(10, [1, 2, 3], [6, 10, 12]), 22)

    def test2(self):
        knapsack = Knapsack()
        self.assertEqual(knapsack.bottom_up(10, [1, 2, 3, 4, 5], [6, 10, 12, 15, 20]), 37)

    def test3(self):
        knapsack = Knapsack()
        self.assertEqual(knapsack.bottom_up(10, [1, 2, 3, 4, 5, 6], [6, 10, 12, 15, 20, 25]), 37)