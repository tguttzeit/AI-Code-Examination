from py_testgen_app.src.Copilot.EgyptianFractions.BookExampleCode.T9.egyptian_fractions import EgyptianFractions

import unittest


class EgyptianFractionsTest(unittest.TestCase):

    def test_1(self):
        egyptian_fractions = EgyptianFractions()
        self.assertEqual(egyptian_fractions.build(2, 3), [2, 6])

    def test_2(self):
        egyptian_fractions = EgyptianFractions()
        self.assertEqual(egyptian_fractions.build(6, 14), [3, 11, 231])

    def test_3(self):
        egyptian_fractions = EgyptianFractions()
        self.assertEqual(egyptian_fractions.build(12, 13), [2, 3, 12, 156])

