from py_testgen_app.src.ChatGPT.EgyptianFractions.BookExampleCode.T7.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian_fractions = EgyptianFractions()

    def test_case1(self):
        result = self.egyptian_fractions.build(4, 7)
        self.assertEqual(result, [1 / 2, 1 / 14])

    def test_case2(self):
        result = self.egyptian_fractions.build(5, 8)
        self.assertEqual(result, [1 / 2, 1 / 8])

    def test_case3(self):
        result = self.egyptian_fractions.build(3, 11)
        self.assertEqual(result, [1 / 4, 1 / 44])


