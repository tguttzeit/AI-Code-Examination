from py_app.src.Copilot.Knapsack.T20.knapsack import Knapsack

import unittest


class KnapsackTest(unittest.TestCase):

    def setUp(self):
        self.sut = Knapsack()

    def test_should_get_maximum_value(self):
        weights = [10, 20, 30]
        values = [60, 100, 120]
        capacity = 50
        expected = 220
        actual = self.sut.bottom_up(capacity, weights, values)
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
