from py_testgen_app.src.Copilot.Knapsack.PromptOnly.T4.knapsack import Knapsack

import unittest

class KnapsackTest(unittest.TestCase):
    # The method setUp() is called before each test_* method.
    def setUp(self):
        self.knapsack = Knapsack()

    # The method tearDown() is called after each test_* method.
    def tearDown(self):
        self.knapsack = None

    # Test case 1
    def test_bottom_up_1(self):
        # Test case 1
        self.assertEqual(self.knapsack.bottom_up(10, [1, 2, 3, 4, 5], [1, 2, 3, 4, 5]), 10)

    # Test case 2
    def test_bottom_up_2(self):
        # Test case 2
        self.assertEqual(self.knapsack.bottom_up(10, [1, 2, 3, 4, 5], [5, 4, 3, 2, 1]), 15)

    # Test case 3
    def test_bottom_up_3(self):
        # Test case 3
        self.assertEqual(self.knapsack.bottom_up(10, [1, 2, 3, 4, 5], [10, 9, 8, 7, 6]), 10)

    # Test case 4
    def test_bottom_up_4(self):
        # Test case 4
        self.assertEqual(self.knapsack.bottom_up(10, [1, 2, 3, 4, 5], [6, 7, 8, 9, 10]), 10)

    # Test case 5
    def test_bottom_up_5(self):
        # Test case 5
        self.assertEqual(self.knapsack.bottom_up(10, [1, 2, 3, 4, 5], [1, 1, 1, 1, 1]), 5)

    # Test case 6
    def test_bottom_up_6(self):
        # Test case 6
        self.assertEqual(self.knapsack.bottom_up(10, [1, 2, 3, 4, 5], [2, 2, 2, 2, 2]), 10)

    # Test case 7
    def test_bottom_up_7(self):
        # Test case 7
        pass