from py_testgen_app.src.Copilot.EgyptianFractions.BookExampleCode.T1.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):

    def setUp(self):
        self.egyptian_fractions = EgyptianFractions()

    def test_egyptian_fractions_1(self):
        self.assertEqual(self.egyptian_fractions.build(6, 14), [1 / 3, 1 / 11, 1 / 231])

    def test_egyptian_fractions_2(self):
        self.assertEqual(self.egyptian_fractions.build(2, 3), [1 / 2, 1 / 6])

    def test_egyptian_fractions_3(self):
        self.assertEqual(self.egyptian_fractions.build(12, 13), [1 / 2, 1 / 3, 1 / 12, 1 / 156])
