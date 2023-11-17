from py_testgen_app.src.Copilot.EgyptianFractions.PromptOnly.T3.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionTest(unittest.TestCase):

    def test_build(self):
        self.assertEqual(EgyptianFractions.build(2, 3), [2, 6])
        self.assertEqual(EgyptianFractions.build(6, 14), [1, 3, 11, 231])
        self.assertEqual(EgyptianFractions.build(12, 13), [1, 2, 3, 12, 156])

    def test_build_2(self):
        self.assertEqual(EgyptianFractions.build(2, 3), [2, 6])
        self.assertEqual(EgyptianFractions.build(6, 14), [1, 3, 11, 231])
        self.assertEqual(EgyptianFractions.build(12, 13), [1, 2, 3, 12, 156])

    def test_build_3(self):
        self.assertEqual(EgyptianFractions.build(2, 3), [2, 6])
        self.assertEqual(EgyptianFractions.build(6, 14), [1, 3, 11, 231])
        self.assertEqual(EgyptianFractions.build(12, 13), [1, 2, 3, 12, 156])
