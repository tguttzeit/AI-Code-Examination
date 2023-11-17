from py_testgen_app.src.Copilot.Knapsack.AIGenerated.T4.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def setUp(self):
        self.knapsack = Knapsack()
    
    def test1(self):
        self.assertEqual(self.knapsack.bottom_up(10, [5, 4, 6, 3], [10, 40, 30, 50]), 90)
    
    def test2(self):
        self.assertEqual(self.knapsack.bottom_up(5, [3, 4, 1, 2], [2, 3, 4, 5]), 7)
    
    def test3(self):
        self.assertEqual(self.knapsack.bottom_up(10, [4, 5, 6], [1, 2, 3]), 0)