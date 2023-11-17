from py_testgen_app.src.ChatGPT.EgyptianFractions.PromptOnly.T9.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):

    def test_positive_fraction(self):
        fractions = EgyptianFractions()
        result = fractions.build(5, 7)
        self.assertEqual(result, [2, 3, 42])

    def test_unit_fraction(self):
        fractions = EgyptianFractions()
        result = fractions.build(1, 8)
        self.assertEqual(result, [8])

    def test_improper_fraction(self):
        fractions = EgyptianFractions()
        result = fractions.build(17, 3)
        self.assertEqual(result, [6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6])

