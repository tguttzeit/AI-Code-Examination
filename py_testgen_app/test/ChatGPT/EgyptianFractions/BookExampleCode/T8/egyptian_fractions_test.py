from py_testgen_app.src.ChatGPT.EgyptianFractions.BookExampleCode.T8.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):

    def test_egyptian_fraction_with_simple_input(self):
        ef = EgyptianFractions()
        result = ef.build(3, 7)
        self.assertEqual(result, [1 / 3, 1 / 11, 1 / 231])

    def test_egyptian_fraction_with_integer_input(self):
        ef = EgyptianFractions()
        result = ef.build(4, 1)
        self.assertEqual(result, [1, 1, 1, 1])

    def test_egyptian_fraction_with_large_denominator(self):
        ef = EgyptianFractions()
        result = ef.build(5, 12345)
        self.assertEqual(result, [1 / 2469, 1 / 9293, 1 / 3087925, 1 / 386315625])


