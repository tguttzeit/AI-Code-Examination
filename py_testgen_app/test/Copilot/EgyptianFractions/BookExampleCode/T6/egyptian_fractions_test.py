from py_testgen_app.src.Copilot.EgyptianFractions.BookExampleCode.T6.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):

    def test_1(self):
        egyptian_fractions = EgyptianFractions()
        self.assertEqual(egyptian_fractions.build(1, 2), [2.0])

    def test_2(self):
        egyptian_fractions = EgyptianFractions()
        self.assertEqual(egyptian_fractions.build(3, 4), [2.0, 4.0])

    def test_3(self):
        egyptian_fractions = EgyptianFractions()
        self.assertEqual(egyptian_fractions.build(6, 14), [3.0, 11.0, 231.0])
