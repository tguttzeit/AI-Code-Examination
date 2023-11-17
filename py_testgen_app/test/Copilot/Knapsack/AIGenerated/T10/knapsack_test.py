from py_testgen_app.src.Copilot.Knapsack.AIGenerated.T10.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):

    def setUp(self):
        self.knapsack = Knapsack()

    def test1(self):
        self.assertEqual(self.knapsack.bottom_up(5, [1, 2, 3], [6, 10, 12]), 22)

    def test2(self):
        self.assertEqual(self.knapsack.bottom_up(5, [1, 2, 3], [6, 10, 12]), 22)

    def test3(self):
        self.assertEqual(self.knapsack.bottom_up(5, [1, 2, 3], [6, 10, 12]), 22)