from py_testgen_app.src.ChatGPT.EgyptianFractions.PromptOnly.T1.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):

    # Test case 1: Test with a simple fraction (1/2)
    def test_simple_fraction(self):
        ef = EgyptianFractions()
        result = ef.build(1, 2)
        self.assertEqual(result, [2])

    # Test case 2: Test with a proper fraction (3/7)
    def test_proper_fraction(self):
        ef = EgyptianFractions()
        result = ef.build(3, 7)
        self.assertEqual(result, [3, 11, 231])

    # Test case 3: Test with an improper fraction (5/2)
    def test_improper_fraction(self):
        ef = EgyptianFractions()
        result = ef.build(5, 2)
        self.assertEqual(result, [3, 4])
