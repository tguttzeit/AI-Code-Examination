from py_testgen_app.src.ChatGPT.EgyptianFractions.PromptOnly.T10.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_positive_fraction(self):
        fractions = EgyptianFractions().build(4, 7)
        self.assertEqual(fractions, [2, 4, 28])

    def test_unit_fraction(self):
        fractions = EgyptianFractions().build(1, 5)
        self.assertEqual(fractions, [5])

    def test_large_fraction(self):
        fractions = EgyptianFractions().build(125, 1296)
        self.assertEqual(fractions, [11, 144, 1296])


