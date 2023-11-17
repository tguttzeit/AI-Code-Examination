from py_testgen_app.src.ChatGPT.EgyptianFractions.BookExampleCode.T9.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):

    def setUp(self):
        self.egyptian_fractions = EgyptianFractions()

    def test_simple_fraction(self):
        result = self.egyptian_fractions.build(3, 7)
        self.assertEqual(result, [1 / 3, 1 / 11, 1 / 231])

    def test_unit_fraction(self):
        result = self.egyptian_fractions.build(1, 4)
        self.assertEqual(result, [1 / 4])

    def test_large_denominator(self):
        result = self.egyptian_fractions.build(7, 987654321)
        self.assertEqual(result, [1 / 141093475, 1 / 282186950, 1 / 564373900, 1 / 1128747800])

