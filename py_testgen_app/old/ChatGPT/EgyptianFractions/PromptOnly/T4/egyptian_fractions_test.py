from py_testgen_app.src.ChatGPT.EgyptianFractions.PromptOnly.T4.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_valid_fraction(self):
        fractions = EgyptianFractions.build(3, 7)
        self.assertEqual(fractions, [3, 11, 231])

    def test_unit_fraction(self):
        fractions = EgyptianFractions.build(1, 5)
        self.assertEqual(fractions, [5])

    def test_improper_fraction(self):
        fractions = EgyptianFractions.build(5, 3)
        self.assertEqual(fractions, [2, 2, 3])

