from py_testgen_app.src.Copilot.EgyptianFractions.BookExampleCode.T2.egyptian_fractions import EgyptianFractions

import unittest


class EgyptianFractionsTest(unittest.TestCase):

    def test_egyptian_fractions_1(self):
        egyptian_fractions = EgyptianFractions()
        self.assertEqual([1 / 2, 1 / 6], egyptian_fractions.build(2, 3))

    def test_egyptian_fractions_2(self):
        egyptian_fractions = EgyptianFractions()
        self.assertEqual([1 / 3, 1 / 11, 1 / 231], egyptian_fractions.build(6, 7))

    def test_egyptian_fractions_3(self):
        egyptian_fractions = EgyptianFractions()
        self.assertEqual([1 / 4, 1 / 12, 1 / 156, 1 / 1716], egyptian_fractions.build(8, 9))

