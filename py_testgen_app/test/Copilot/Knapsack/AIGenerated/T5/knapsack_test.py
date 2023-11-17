from py_testgen_app.src.Copilot.Knapsack.AIGenerated.T5.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()
        
    def test_knapsack_1(self):
        capacity = 10
        weights = [5, 4, 6, 3]
        values = [10, 40, 30, 50]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 90)
        
    def test_knapsack_2(self):
        capacity = 100
        weights = [5, 4, 6, 3]
        values = [10, 40, 30, 50]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 130)
        
    def test_knapsack_3(self):
        capacity = 1000
        weights = [5, 4, 6, 3]
        values = [10, 40, 30, 50]
        self.assertEqual(self.knapsack.bottom_up(capacity, weights, values), 130)