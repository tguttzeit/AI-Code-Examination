from py_testgen_app.src.Copilot.Knapsack.AIGenerated.T3.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()
        self.capacity = 50
        self.weights = [10, 20, 30]
        self.values = [60, 100, 120]
        
    def test_bottom_up(self):
        self.assertEqual(self.knapsack.bottom_up(self.capacity, self.weights, self.values), 220)
        self.assertEqual(self.knapsack.bottom_up(10, [10], [60]), 60)
        self.assertEqual(self.knapsack.bottom_up(0, [10], [60]), 0)