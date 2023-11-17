from py_testgen_app.src.Copilot.Knapsack.AIGenerated.T1.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()
    
    def test_bottom_up(self):
        self.assertEqual(self.knapsack.bottom_up(10, [5, 4, 6, 3], [10, 40, 30, 50]), 90)
        self.assertEqual(self.knapsack.bottom_up(10, [5, 4, 6, 3], [10, 40, 30, 50]), 90)
        self.assertEqual(self.knapsack.bottom_up(10, [5, 4, 6, 3], [10, 40, 30, 50]), 90)