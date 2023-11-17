from py_testgen_app.src.Copilot.EgyptianFractions.PromptOnly.T1.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionTest(unittest.TestCase):
    def setUp(self):
        self.egyptian_fractions = EgyptianFractions()
        self.num1 = 6
        self.den1 = 14
        self.num2 = 2
        self.den2 = 3
        self.num3 = 12
        self.den3 = 13

    def test_build(self):
        self.assertEqual(self.egyptian_fractions.build(self.num1, self.den1), [1, 2, 7])
        self.assertEqual(self.egyptian_fractions.build(self.num2, self.den2), [1, 2])
        self.assertEqual(self.egyptian_fractions.build(self.num3, self.den3), [1, 2, 3, 4, 156])

    def tearDown(self):
        self.egyptian_fractions = None
        self.num1 = None
        self.den1 = None
        self.num2 = None
        self.den2 = None
        self.num3 = None
        self.den3 = None
