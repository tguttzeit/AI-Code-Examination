from py_testgen_app.src.ChatGPT.EgyptianFractions.PromptOnly.T5.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):

    def test_simple_fraction(self):
        fractions = EgyptianFractions()
        result = fractions.build(3, 7)
        self.assertEqual(result, [2, 5, 70])

    def test_unit_fraction(self):
        fractions = EgyptianFractions()
        result = fractions.build(1, 5)
        self.assertEqual(result, [5])

    def test_improper_fraction(self):
        fractions = EgyptianFractions()
        result = fractions.build(11, 4)
        self.assertEqual(result, [3, 5, 44])


