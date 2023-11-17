from py_testgen_app.src.ChatGPT.EgyptianFractions.PromptOnly.T3.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_build_positive_input(self):
        result = EgyptianFractions.build(4, 7)
        self.assertEqual(result, [2, 7, 14])

    def test_build_negative_input(self):
        result = EgyptianFractions.build(-3, 5)
        self.assertEqual(result, None)

    def test_build_invalid_denominator(self):
        result = EgyptianFractions.build(2, 0)
        self.assertEqual(result, None)

