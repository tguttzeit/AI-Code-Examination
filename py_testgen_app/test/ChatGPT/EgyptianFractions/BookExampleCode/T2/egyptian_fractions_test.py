from py_testgen_app.src.ChatGPT.EgyptianFractions.BookExampleCode.T2.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_egyptian_fraction_1(self):
        egyptian = EgyptianFractions()
        result = egyptian.build(3, 7)
        expected = [1 / 3, 1 / 11, 1 / 231]  # Expected result for 3/7
        self.assertEqual(result, expected)

    def test_egyptian_fraction_2(self):
        egyptian = EgyptianFractions()
        result = egyptian.build(4, 13)
        expected = [1 / 4, 1 / 18, 1 / 468]  # Expected result for 4/13
        self.assertEqual(result, expected)

    def test_egyptian_fraction_3(self):
        egyptian = EgyptianFractions()
        result = egyptian.build(5, 6)
        expected = [1 / 2, 1 / 3]  # Expected result for 5/6
        self.assertEqual(result, expected)

