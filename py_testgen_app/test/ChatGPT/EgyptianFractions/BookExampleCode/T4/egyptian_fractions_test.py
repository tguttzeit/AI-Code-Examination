from py_testgen_app.src.ChatGPT.EgyptianFractions.BookExampleCode.T4.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian = EgyptianFractions()

    def test_case_1(self):
        result = self.egyptian.build(5, 7)
        self.assertEqual(result, [2, 10, 70])

    def test_case_2(self):
        result = self.egyptian.build(4, 13)
        self.assertEqual(result, [4, 18, 468])

    def test_case_3(self):
        result = self.egyptian.build(3, 11)
        self.assertEqual(result, [4, 44])

