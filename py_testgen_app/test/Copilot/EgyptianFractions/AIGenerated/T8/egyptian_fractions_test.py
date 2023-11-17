from py_testgen_app.src.Copilot.EgyptianFractions.AIGenerated.T8.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian_fractions = EgyptianFractions()

    def test_egyptian_fractions_1(self):
        self.assertEqual(self.egyptian_fractions.build(6, 14), [3, 11, 231])

    def test_egyptian_fractions_2(self):
        self.assertEqual(self.egyptian_fractions.build(2, 3), [2, 6])

    def test_egyptian_fractions_3(self):
        self.assertEqual(self.egyptian_fractions.build(12, 13), [2, 3, 12, 156])
