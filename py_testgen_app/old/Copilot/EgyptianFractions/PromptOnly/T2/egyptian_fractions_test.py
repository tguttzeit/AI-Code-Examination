from py_testgen_app.src.Copilot.EgyptianFractions.PromptOnly.T2.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionTest(unittest.TestCase):

    def test_build_1(self):
        self.assertEqual(EgyptianFractions.build(6, 14), [1, 2, 7, 98])

    def test_build_2(self):
        self.assertEqual(EgyptianFractions.build(2, 3), [2, 6])

    def test_build_3(self):
        self.assertEqual(EgyptianFractions.build(12, 13), [1, 2, 3, 12, 156])
