from py_testgen_app.src.ChatGPT.EgyptianFractions.BookExampleCode.T3.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_egyptian_fraction_1(self):
        ef = EgyptianFractions()
        result = ef.build(4, 7)
        self.assertEqual(result, [1, 2, 28])

    def test_egyptian_fraction_2(self):
        ef = EgyptianFractions()
        result = ef.build(5, 8)
        self.assertEqual(result, [1, 2, 8])

    def test_egyptian_fraction_3(self):
        ef = EgyptianFractions()
        result = ef.build(3, 11)
        self.assertEqual(result, [1, 4, 44])

