from py_testgen_app.src.Copilot.EgyptianFractions.PromptOnly.T8.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionTest(unittest.TestCase):

    def test_build(self):
        self.assertEqual(EgyptianFractions.build(2, 3), [2, 6])
        self.assertEqual(EgyptianFractions.build(6, 14), [1, 3, 11, 231])
        self.assertEqual(EgyptianFractions.build(12, 13), [1, 2, 3, 12, 156, 2028])

    def test_build_with_zero(self):
        self.assertEqual(EgyptianFractions.build(0, 0), "You can't divide by zero")
        self.assertEqual(EgyptianFractions.build(0, 7), "You can't divide by zero")
        self.assertEqual(EgyptianFractions.build(7, 0), "You can't divide by zero")

    def test_build_with_negative(self):
        self.assertEqual(EgyptianFractions.build(-2, 3), [-1, 3])
        self.assertEqual(EgyptianFractions.build(2, -3), [-1, 3])
        self.assertEqual(EgyptianFractions.build(-2, -3), [1, 3])
        self.assertEqual(EgyptianFractions.build(-6, 14), [-1, 3, 11, 231])
        self.assertEqual(EgyptianFractions.build(6, -14), [-1, 3, 11, 231])
        self.assertEqual(EgyptianFractions.build(-6, -14), [1, 3, 11, 231])

    def test_build_with_not_int(self):
        self.assertEqual(EgyptianFractions.build(2.5, 3), "You can't divide by zero")
        self.assertEqual(EgyptianFractions.build(2, 3.5), "You can't divide by zero")
        self.assertEqual(EgyptianFractions.build(2.5, 3.5), "You can't divide by zero")

    def test_build_with_not_int_negative(self):
        self.assertEqual(EgyptianFractions.build(-2.5, 3), "You can't divide by zero")
        self.assertEqual(EgyptianFractions.build(2.5, -3), "You can't divide by zero")
        self.assertEqual(EgyptianFractions.build(-2.5, -3), "You can't divide by zero")

    def test_build_with_not_int_zero(self):
