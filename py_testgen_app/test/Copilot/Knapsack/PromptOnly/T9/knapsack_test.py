from py_testgen_app.src.Copilot.Knapsack.PromptOnly.T9.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    def test_1(self):
        k = Knapsack()
        self.assertEqual(k.bottom_up(10, [1, 2, 3, 4], [1, 2, 3, 4]), 10)

    def test_2(self):
        k = Knapsack()
        self.assertEqual(k.bottom_up(10, [1, 2, 3, 4], [1, 2, 3, 5]), 10)

    def test_3(self):
        k = Knapsack()
        self.assertEqual(k.bottom_up(10, [1, 2, 3, 4], [1, 2, 3, 6]), 10)

    def test_4(self):
        k = Knapsack()
        self.assertEqual(k.bottom_up(10, [1, 2, 3, 4], [1, 2, 3, 7]), 10)

    def test_5(self):
        k = Knapsack()
        self.assertEqual(k.bottom_up(10, [1, 2, 3, 4], [1, 2, 3, 8]), 10)

    def test_6(self):
        k = Knapsack()
        self.assertEqual(k.bottom_up(10, [1, 2, 3, 4], [1, 2, 3, 9]), 10)

    def test_7(self):
        k = Knapsack()
        self.assertEqual(k.bottom_up(10, [1, 2, 3, 4], [1, 2, 3, 10]), 10)

    def test_8(self):
        k = Knapsack()
        self.assertEqual(k.bottom_up(10, [1, 2, 3, 4], [1, 2, 4, 4]), 10)

    def test_9(self):
        k = Knapsack()
        self.assertEqual(k.bottom_up(10, [1, 2, 3, 4], [1, 3, 3, 4]), 10)

    def test_10(self):
        k = Knapsack()