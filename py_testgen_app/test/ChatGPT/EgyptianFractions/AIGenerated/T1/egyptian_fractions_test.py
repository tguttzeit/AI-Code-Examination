from py_testgen_app.src.ChatGPT.EgyptianFractions.AIGenerated.T1.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.egyptian = EgyptianFractions()

    def test_case1(self):
        result = self.egyptian.build(4, 7)
        self.assertEqual(result, [2, 7, 28])

    def test_case2(self):
        result = self.egyptian.build(2, 3)
        self.assertEqual(result, [2, 3])

    def test_case3(self):
        result = self.egyptian.build(5, 6)
        self.assertEqual(result, [2, 3, 10])


