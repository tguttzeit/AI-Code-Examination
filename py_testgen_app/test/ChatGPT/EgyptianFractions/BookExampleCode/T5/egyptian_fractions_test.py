from py_testgen_app.src.ChatGPT.EgyptianFractions.BookExampleCode.T5.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.ef = EgyptianFractions()

    def test_case_1(self):
        result = self.ef.build(3, 7)
        self.assertEqual(result, [1 / 3, 1 / 11, 1 / 231])

    def test_case_2(self):
        result = self.ef.build(5, 8)
        self.assertEqual(result, [1 / 2, 1 / 8])

    def test_case_3(self):
        result = self.ef.build(2, 5)
        self.assertEqual(result, [1 / 3, 1 / 15])


