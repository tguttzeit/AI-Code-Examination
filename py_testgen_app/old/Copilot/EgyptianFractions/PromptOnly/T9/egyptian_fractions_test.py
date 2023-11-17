from py_testgen_app.src.Copilot.EgyptianFractions.PromptOnly.T9.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionTest(unittest.TestCase):
    def test_build(self):
        self.assertEqual(EgyptianFractions.build(2, 3), [2, 6])
        self.assertEqual(EgyptianFractions.build(6, 14), [3, 6, 42])
        self.assertEqual(EgyptianFractions.build(12, 13), [2, 3, 12, 156])
        self.assertEqual(EgyptianFractions.build(5, 121), [25, 1575])

    def test_build2(self):
        self.assertEqual(EgyptianFractions.build(2, 3), [2, 6])
        self.assertEqual(EgyptianFractions.build(6, 14), [3, 6, 42])
        self.assertEqual(EgyptianFractions.build(12, 13), [2, 3, 12, 156])
        self.assertEqual(EgyptianFractions.build(5, 121), [25, 1575])

    def test_build3(self):
        self.assertEqual(EgyptianFractions.build(2, 3), [2, 6])
        self.assertEqual(EgyptianFractions.build(6, 14), [3, 6, 42])
        self.assertEqual(EgyptianFractions.build(12, 13), [2, 3, 12, 156])
        self.assertEqual(EgyptianFractions.build(5, 121), [25, 1575])
